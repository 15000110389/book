package com.atguigu.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取业务鉴别字符串
        String action = request.getParameter("action");
        try {
            // 通过业务鉴别字符串获取相应的方法反射对象
            Method method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 反射调用业务方法
            method.invoke(this,request,response );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
