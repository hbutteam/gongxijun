package com.qunar.dbutil;


import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.qunar.bean.PageVistor;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by gongxijun on 16-3-22.
 */
public class DbUtil {

    ArrayList
    private static final String CONFIG_PROPERTIES = "/config.properties";
    private static Properties prop;

    static Logger logger = LoggerFactory.getLogger(DbUtil.class);
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    static {
        try {

            prop = new Properties();
            try {
                prop.load(DbUtil.class.getClassLoader().getResourceAsStream(CONFIG_PROPERTIES));
                logger.info(prop.getProperty("DRIVER_CLASS").trim());
                Class.forName(prop.getProperty("DRIVER_CLASS").trim());
            } catch (IOException e) {
                logger.info(String.format("IO exception0 : %s", e));
            }
        } catch (ClassNotFoundException e) {
            logger.info(String.format("sql exception0 : %s", e));
        }
    }


    public List<PageVistor> Query(String sql) {

        List<PageVistor> PageVisitors = Lists.newArrayList();

        try {
            connection = DriverManager.getConnection(prop.getProperty("SQL_URL"),
                    prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                PageVisitors.add(new PageVistor(0, "", resultSet.getString(1), resultSet.getInt(2)));
            }
        } catch (SQLException e) {
            logger.info(String.format("exe inf :%s", e));
        } finally {
            try {
                if (!resultSet.isClosed())
                    resultSet.close();
                if (!preparedStatement.isClosed())
                    preparedStatement.close();
                if (!connection.isClosed())
                    connection.close();

            } catch (SQLException e) {
                logger.info(String.format("sql exception1 : %s", e));
            }
        }
        return PageVisitors;
    }


    public void Update(String sql) {

        try {
            logger.info(sql);
            connection = DriverManager.getConnection(prop.getProperty("SQL_URL"),
                    prop.getProperty("USERNAME"), prop.getProperty("PASSWORD"));
            preparedStatement = connection.prepareStatement(sql);
            int var = preparedStatement.executeUpdate();
            if (0 == var) logger.info("UpdateData failure !");

        } catch (SQLException e) {
            logger.info(String.format("sql exception2 : %s", e));

        } finally {
            try {
                if (!preparedStatement.isClosed())
                    preparedStatement.close();
                if (!connection.isClosed())
                    connection.close();

            } catch (SQLException e) {
                logger.info(String.format("sql exception3 : %s", e));
            }
        }
    }
}