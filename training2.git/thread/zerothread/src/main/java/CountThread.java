import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * Created by gongxijun on 16-3-24.
 */
public class CountThread {


    private static Logger logger;

    static {
        logger= LoggerFactory.getLogger(CountThread.class);
    }

    public  void MainRun() {

        for (int i = 0;; i++) {
            logger.info(String.format("the thread num = %d",i));
             new Thread(new HoldThread()).start();
        }
    }


 class HoldThread extends Thread {

        private  Logger logger=LoggerFactory.getLogger(HoldThread.class);

        CountDownLatch cdl = new CountDownLatch(1);

        public HoldThread() {
            this.setDaemon(true);
        }

        public void run() {
            try {
                cdl.await();
            } catch (InterruptedException e) {
                logger.info(String.format("interrupt: %s", e));
            }
        }
    }
}
