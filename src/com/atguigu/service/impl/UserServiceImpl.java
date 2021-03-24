package com.atguigu.service.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.User;
import com.atguigu.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPassword());
    }

    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public boolean existsUsername(String username) {
        User user = userDao.queryUserByUsername(username);
        // 如果值为null，说明没查到，可用
        if (user == null) {
            return false;
        }
        // 用户名查到了，已存在，就不可用
        return true;
    }
}
