package com.qunar.dbutil;


import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qunar.bean.PageVistor;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

/**
 * Created by gongxijun on 16-3-22.
 */
public class DbUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SQLURL = "jdbc:mysql://localhost:3306/test_jdbc";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Qunar.gxjun";


    //private  static final String DBURL = "java:/comp/env/testdb";
    static Logger logger = LoggerFactory.getLogger(DbUtil.class);
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    DataSource dataSource;
    ResultSet resultSet = null;

    static {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            logger.info(" exception :" + e);
        }

    }


    public DbUtil() {
    }

    /**
     * 链接数据库
     */
    public void ToConnect() {

        try {
            connection = DriverManager.getConnection(SQLURL, USERNAME, PASSWORD);
        } catch (SQLException e) {

            logger.info("exe inf :" + e);
        }

    }

    public List<PageVistor> Query(String sql) {

        List<PageVistor> pageVistors = Lists.newArrayList();

        try {
            connection = DriverManager.getConnection(SQLURL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                pageVistors.add(new PageVistor(0, "", resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            logger.info("exe inf :" + e);
        } finally {
            try {

                if (!resultSet.isClosed())
                    resultSet.close();
                if (!preparedStatement.isClosed())
                    preparedStatement.close();
                if (!connection.isClosed())
                    connection.close();

            } catch (SQLException e) {
                logger.info("sql exception : " + e);
            }
        }
        return pageVistors;
    }


    public void Update(String sql) {

        try {
            logger.info(sql);
            connection = DriverManager.getConnection(SQLURL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(sql);
            int var = preparedStatement.executeUpdate();
            if (0 == var) logger.info("UpdateData failure !");

        } catch (SQLException e) {
            logger.info("sql exception : " + e);

        } finally {
            try {
                if (!preparedStatement.isClosed())
                    preparedStatement.close();
                if (!connection.isClosed())
                    connection.close();

            } catch (SQLException e) {
                logger.info("sql exception : " + e);
            }
        }
    }
}