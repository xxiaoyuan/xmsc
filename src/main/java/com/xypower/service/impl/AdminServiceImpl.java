package com.xypower.service.impl;

import com.xypower.mapper.AdminMapper;
import com.xypower.pojo.Admin;
import com.xypower.pojo.AdminExample;
import com.xypower.service.AdminService;
import com.xypower.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    //在业务逻辑层中有数据访问层的对象
    @Autowired
    AdminMapper adminMapper;
    @Override
    public Admin login(String name, String pwd) {
        //根据传入的用户名到数据库查询相应的用户对象
        //如果有条件，则一定创建AdminExample的对象,用来封装条件
        AdminExample example = new AdminExample();
        //添加用户名a_name条件
        example.createCriteria().andANameEqualTo(name);

        List<Admin> list = adminMapper.selectByExample(example);
        if (list.size()>0){
           Admin admin = list.get(0);//用户名不重复
            //如果查询到的用户对象再进行比对
            String miPwd = MD5Util.getMD5(pwd);
            if (miPwd.equals(admin.getaPass())){
                return admin;
            }
        }
        return null;
    }

    @Override
    public int saveUser(Admin admin) {
        String miPwd=MD5Util.getMD5(admin.getaPass());
        admin.setaPass(miPwd);
        return adminMapper.insert(admin);
    }
}
