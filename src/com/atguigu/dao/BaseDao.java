package com.atguigu.dao;

import com.atguigu.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    QueryRunner queryRunner = new QueryRunner();

    /**
     * 用于执行 insert , delete , update的sql语句<br/>
     *
     * @param sql  执行的sql语句
     * @param args sql语句中占位符的参数值<br/>
     * @return 影响的行数
     */
    protected int update(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    /**
     * 执行查询返回一个JavaBean的sql语句
     *
     * @param type 返回的具体类型
     * @param sql  sql语句
     * @param args sql中占位符的参数值
     * @param <T>  具体的类型
     * @return 返回null，说明失败或没有查到，有值是查询成功！！！
     */
    protected <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    /**
     * 执行查询返回多个JavaBean的sql语句
     *
     * @param type 返回的具体类型
     * @param sql  sql语句
     * @param args sql中占位符的参数值
     * @param <T>  具体的类型
     * @return 返回null，说明失败或没有查到，有值是查询成功！！！
     */
    protected <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }

    /**
     * 用于执行查询结果是一行，只取个别列的情况(一行一列)<br/>
     *
     * @param sql  sql语句
     * @param args sql中的参数值
     * @return 返回个别列的结果
     */
    protected Object queryForSingleValue(String sql, Object... args) {
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connection, sql, new ScalarHandler(), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.closeConnection(connection);
        }
    }


}
