package com.atguigu.dao;

import com.atguigu.pojo.User;

public interface UserDao {

    /**
     * 根据用户名和密码到数据库查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 查询结果
     */
    public User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 根据用户名查询用户
     *
     * @param username 用户名
     * @return 查询的结果
     */
    public User queryUserByUsername(String username);

    /**
     * 添加用户到数据库
     *
     * @param user 添加的用户信息
     * @return 影响的行数
     */
    public int saveUser(User user);


}
