package com.atguigu.controller;

import com.atguigu.pojo.User;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.atguigu.util.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/userServlet")
public class UserServlet extends BaseServlet {

    UserService userService = new UserServiceImpl();

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        1 获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String code = request.getParameter("code");


        User user = WebUtils.copyParamToBean(request.getParameterMap(),new User());


        //        2 检查验证码是否正确 abcde
        if ("abcde".equalsIgnoreCase(code)) {
//        3 检查用户名是否可用？
            if (userService.existsUsername(username)) {
                System.out.println("用户名已存在！！！");

                request.setAttribute("msg","用户名已存在");
                request.setAttribute("username",username);
                request.setAttribute("email",email);

                //        跳回注册页面
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
            } else {
                //        用户名可用
                //                保存到数据库
                userService.registUser(new User(null,username,password,email));
                //        跳到注册成功页面 regist_success.jsp
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request,response);
            }
        } else {
            System.out.println("验证码错误");
            request.setAttribute("msg","验证码错误");
            request.setAttribute("username",username);
            request.setAttribute("email",email);
//        跳回注册页面
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request,response);
        }


    }

    /**
     * 表示登录
     */
    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //        1 获取请求的参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        2 调用UserService.login()
        User loginUser = userService.login(new User(null, username, password, null));
//        3 根据返回值，判断是否登录成功
        if (loginUser == null) {
            //        值为null，登录失败
            request.setAttribute("msg","用户名或密码错误");
            request.setAttribute("username",username);
//                跳到登录页面
            System.out.println("登录失败");
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request,response);
        } else {
            //        有值，登录成功。
            System.out.println("登录成功");
            //        跳到login_success.jsp页面
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request,response);
        }
    }




}
