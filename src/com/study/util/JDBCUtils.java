package com.study.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class JDBCUtils {
    private static DataSource dataSource = new ComboPooledDataSource("webDataSource");

    /**
     * 获得连接
     * @return
     */
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }


    /**
     * 释放连接
     * @param connection
     */
    public static void releaseConnection(Connection connection){
        try {
            if(connection!=null)
                connection = null;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
