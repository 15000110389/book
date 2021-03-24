package com.atguigu.junit;

        import com.atguigu.dao.UserDao;
        import com.atguigu.dao.impl.UserDaoImpl;
        import com.atguigu.pojo.User;
        import org.junit.Test;

        import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByUsernameAndPassword() {
        if (userDao.queryUserByUsernameAndPassword("admin", "admin1") == null) {
            System.out.println(" 登录失败 ");
        } else {
            System.out.println(" 登录成功 ");
        }
    }

    @Test
    public void queryUserByUsername() {
        String username = "admin";
        if (userDao.queryUserByUsername(username) == null) {
            System.out.println(" 【" + username + "】用户名可用 ");
        } else {
            System.out.println(" 【" + username + "】用户名不可用 ");
        }
    }

    @Test
    public void saveUser() {
        userDao.saveUser(new User(null,"abc168","123456","abc168@qq.com"));
        userDao.saveUser(new User(null,"bbj68","123456","bbj168@qq.com"));
    }
}