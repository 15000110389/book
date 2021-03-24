package com.atguigu.util;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

    static DruidDataSource dataSource;

    static {
        try {
            // 属性（键值对）类
            Properties properties = new Properties();

            // 通过类加载器，读取配置文件
            /**
             * ClassLoader 类加载器，从源码目录下（src目录）加载指定的配置文件
             */
            InputStream resourceAsStream = JdbcUtils.class.getClassLoader()
                    .getResourceAsStream("jdbc.properties");
            // 从流中，载入键值对信息
            properties.load(resourceAsStream);

            // 通过 DruidDataSourceFactory 创建数据库连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);

//            System.out.println(dataSource.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 从数据库连接池中获取连接 <br/>
     *
     * @return 返回null获取连接失败，有值，就获取成功！！！
     */
    public static Connection getConnection() {
        Connection conn = null;

        try {
            // 从数据库连接池中获取连接
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            // 记录日志 == 甚至还可以抛异常
        }

        return conn;
    }

    /**
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                // 关闭连接==放回数据库连接池中
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
