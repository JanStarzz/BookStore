package com.study.test;

import com.study.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;


public class JDBCUtilsTest {
    @Test
    public void getConnection(){
        Connection connection = JDBCUtils.getConnection();
        System.out.println(connection);
        JDBCUtils.releaseConnection(connection);
    }
}
