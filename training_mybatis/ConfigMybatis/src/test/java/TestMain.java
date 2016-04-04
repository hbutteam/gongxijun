import com.google.common.base.Joiner;
import com.qunar.fresh.bean.FightEmployers;
import com.qunar.fresh.model.dao.DBUtil;
import org.apache.ibatis.executor.result.DefaultResultHandler;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;


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
        SqlSession session;
        session = DBUtil.createSession();

        try {
            FightEmployers ticket;
            ApplicationContext applicationContext = new FileSystemXmlApplicationContext("classpath:spring-config.xml");
            ticket = (FightEmployers) applicationContext.getBean("ema");


            session.insert(Joiner.on("").join(FightEmployers.class.getName(), ".add"), ticket);
            session.commit();

            DefaultResultHandler handler = new DefaultResultHandler();
            session.select(Joiner.on("").join(FightEmployers.class.getName(), ".query"), ticket, handler);
            for (Object employer : handler.getResultList()) {
                FightEmployers fightEmployers = (FightEmployers) employer;
                logger.info(fightEmployers.getEmployer_name());
                logger.info(fightEmployers.getWork_address());
                logger.info(fightEmployers.getQtalk_id());
                logger.info(fightEmployers.getSex());
                logger.info(fightEmployers.getStatus());
                logger.info(fightEmployers.getTell());

            }

            session.select(Joiner.on("").join(FightEmployers.class.getName(), ".queryById"), ticket, handler);
            for (Object employer : handler.getResultList()) {
                FightEmployers fightEmployers = (FightEmployers) employer;
                logger.info(fightEmployers.getEmployer_name());
                logger.info(fightEmployers.getWork_address());
                logger.info(fightEmployers.getQtalk_id());
                logger.info(fightEmployers.getSex());
                logger.info(fightEmployers.getStatus());
                logger.info(fightEmployers.getTell());
            }

            session.update(Joiner.on("").join(FightEmployers.class.getName(), ".modify"), ticket);

            session.delete(Joiner.on("").join(FightEmployers.class.getName(), ".remove"), ticket);


        } catch (BeansException e) {
            logger.info(Joiner.on(".").join("BeansException", e));
        } finally {

            if (null != session) session.close();
        }

    }
}