package com.xypower.controller;

import com.xypower.pojo.Admin;
import com.xypower.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    //所有的界面层一定会有业务逻辑层的对象
    @Autowired
    AdminService adminService;
    //实现登录判断进行相应的跳转
    @RequestMapping("/login")
    public String login(String name, String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name,pwd);
        if (admin!=null){
            //登录成功
            request.setAttribute("admin",admin);
            return "main";
        }else {
            //登录失败
            request.setAttribute("errmsg","用户名或密码不正确");
            return "login";
        }

    }

    @RequestMapping("/regist")
    public String login(String rname,String rpwd,String mpwd,HttpServletRequest request){
        if (rpwd==null||rpwd==""){
            request.setAttribute("errmsg","密码不为空!");
            return "regist";
        }else if(rname==null||rname==""){
            request.setAttribute("errmsg","用户名不为空!");
            return "regist";
        }else if(!rpwd.equals(mpwd)){
            request.setAttribute("errmsg","重复密码错误!");
            return "regist";
        }else{
            Admin admin = new Admin();
            admin.setaName(rname);
            admin.setaPass(mpwd);
            int num = -1;
            try {
                num = adminService.saveUser(admin);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (num > 0) {
                request.setAttribute("errmsg", "注册成功");
            } else {
                request.setAttribute("errmsg", "注册失败");
            }
            return "login";
        }
    }

}
