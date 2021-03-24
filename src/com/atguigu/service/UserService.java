package com.atguigu.service;

import com.atguigu.pojo.User;

public interface UserService {

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 注册
     *
     * @param user
     */
    public void registUser(User user);

    /**
     * 检查用户名是否可用
     *
     * @param username 查询的用户名
     * @return 返回true表示用户名已存在，不可用<br/>
     * 返回false，表示用户名不存在，可用<br/>
     */
    public boolean existsUsername(String username);


}
