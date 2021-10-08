package com.xypower.service;

import com.xypower.pojo.Admin;

public interface AdminService {
    //完成登录判断
    Admin login(String name, String pwd);
    //插入用户数据
    int saveUser(Admin admin);
}
