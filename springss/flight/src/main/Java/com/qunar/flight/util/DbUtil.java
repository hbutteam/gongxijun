package com.qunar.flight.util;

import com.google.common.collect.Lists;
import com.qunar.flight.bean.SqlBean;
import com.qunar.flight.bean.TicketBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.sql.*;
import java.util.List;

/**
 * Created by gongxijun on 16-3-29.
 */
public class DbUtil {

    private static final String CONFIG_PROPERTIES = "classpath:dbConfig.xml";
    static Logger logger = LoggerFactory.getLogger(DbUtil.class);
    private static SqlBean dataBean;
    private static BeanFactory beanFactory;
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    static {
        try {
            beanFactory = new FileSystemXmlApplicationContext(CONFIG_PROPERTIES);

            dataBean = (SqlBean) beanFactory.getBean("dbBean");
            Class.forName(dataBean.getDriver());
        } catch (ClassNotFoundException e) {
            logger.info(String.format("sql exception0 : %s", e));
        }
    }


    public List<TicketBean> Query(String sql) {

        List<TicketBean> ticketBeans = Lists.newArrayList();

        try {
            connection = DriverManager.getConnection(dataBean.getUrl(),
                    dataBean.getUsername(), dataBean.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                ticketBeans.add(new TicketBean(resultSet.getInt(1),
                        resultSet.getString(2), resultSet.getString(3),
                        resultSet.getInt(4), resultSet.getString(5),
                        resultSet.getInt(6), resultSet.getDate(7)));
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
        return ticketBeans;
    }


    public void Update(String sql) {
        try {

            connection = DriverManager.getConnection(dataBean.getUrl(),
                    dataBean.getUsername(), dataBean.getPassword());
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
