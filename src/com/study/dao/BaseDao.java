package com.study.dao;

import com.study.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BaseDao<T> {
    QueryRunner runner = new QueryRunner();
    private Class<T> type;
    //获取实际的type

    public BaseDao() {
    //获得父类型的class
        ParameterizedType superClass = (ParameterizedType) this.getClass().getGenericSuperclass();

        type = (Class<T>) superClass.getActualTypeArguments()[0];
    }

    /**
     * 获得一个对象
     * @return
     */
    public T getBean(String sql,Object ...args) {
        Connection connection = JDBCUtils.getConnection();
        T query = null;
        try {
            query = runner.query(connection,sql,new BeanHandler<>(type),args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(connection);
        }
        return query;
    }
    /**
     * 获得对象数组
     */
    public List<T> getBeanList(String sql, Object ...args){
        Connection connection = JDBCUtils.getConnection();
        List<T> query = null;
        try {
            query = runner.query(connection,sql,new  BeanListHandler<>(type),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.releaseConnection(connection);
        }
        return query;
    }

    /**
     * 执行增删改
     * @return
     */
    public int update(String sql,Object ...args){
        int count = 0;
        Connection connection = JDBCUtils.getConnection();
        try {
            count = runner.update(connection,sql,args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return count;
    }

    /**
     * 查询单个值
     * @param sql
     * @param args
     * @return
     */

    public Object getSingleValue(String sql,Object ...args){

        Object query = null;
        Connection connection = JDBCUtils.getConnection();
        try {
            query = runner.query(connection,sql,new ScalarHandler(),args);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtils.releaseConnection(connection);
        }
        return query;
    }

}
