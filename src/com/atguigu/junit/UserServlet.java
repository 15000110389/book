package com.atguigu.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet {

    public void login(){
        System.out.println(
                " login() method called!!! "
        );
    }


    public void regist(){
        System.out.println(
                " regist() method called!!! "
        );
    }


    public void updatePassword(){
        System.out.println(
                " updatePassword() method called!!! "
        );
    }


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        String action = "login";

        UserServlet userServlet = new UserServlet();

        // 通过业务鉴别字符串，获取到相应的业务方法反射对象
        Method method = UserServlet.class.getDeclaredMethod(action);

        method.invoke(userServlet);

    }


}
