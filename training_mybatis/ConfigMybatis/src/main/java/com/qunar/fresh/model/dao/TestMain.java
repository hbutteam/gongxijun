package com.qunar.fresh.model.dao;

import com.google.common.base.Joiner;
import com.qunar.fresh.bean.FightTicket;
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
public class TestMain {

    private static Logger logger;

    static {
        logger = LoggerFactory.getLogger(TestMain.class);
    }

     //@Test
    public static void main(String[] args) {

        SqlSession session = null;

        try {

            //创建配置文件（mybatis-config.xml）的是输入流
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            //创建SQLSessionFactory
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //创建SQLSession
            session = factory.openSession();

            FightTicket fightTicket = new FightTicket();
            fightTicket.setCnt(222);
            fightTicket.setName("王小明");
            fightTicket.setUrl("www.baidu.com");
            session.insert(Joiner.on("").join(FightTicket.class.getName(),".add"), fightTicket);
            session.commit();
        } catch (IOException e) {
            logger.info(Joiner.on(",").join("IOException", e));
        } finally {

            if (null != session)
                session.close();
        }
    }
}