package com.atguigu.junit;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void login() {
        if (userService.login(new User(null, "admin", "admin", null)) == null) {
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void registUser() {
        userService.registUser(new User(null,"TTWW88","666666","TTWW88@qq.com"));
    }

    @Test
    public void existsUsername() {
        if (userService.existsUsername("TTWW8812")) {
            System.out.println("已存在，不可用");
        } else {
            System.out.println("用户名可用！");
        }
    }
}