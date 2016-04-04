package com.qunar.fresh.model.dao;

import com.google.common.base.Joiner;
import com.qunar.fresh.model.dao.abstractdao.AbstractUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by gongxijun on 16-4-1.
 */
public class DBUtil extends AbstractUtil {

    private static Logger logger = null;
    static SqlSession session = null;
    static SqlSessionFactory factory = null;


    public static SqlSession createSession() {

        if (null == session) {
            session = factory.openSession();
        }
        return session;
    }

    static {

        InputStream is = null;
        logger = LoggerFactory.getLogger(DBUtil.class);
        //创建配置文件（mybatis-config.xml）的是输入流
        try {
            is = Resources.getResourceAsStream(CONFIG_MYBATIS);
        } catch (IOException e) {
            logger.info(Joiner.on(",").join("IOException", e));
        }
        //创建SQLSessionFactory
        if (null == factory)
            factory = new SqlSessionFactoryBuilder().build(is);
    }

}
