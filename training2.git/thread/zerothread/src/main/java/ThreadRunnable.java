import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gongxijun on 16-3-23.
 */
public class ThreadRunnable {

    static Logger logger = LoggerFactory.getLogger(Object.class);


    public static void _main(String[] args) {

        A aa = new A();
        B bb = new B();

        Thread a = new Thread(aa), b = new Thread(bb);
        a.start();
        b.start();

    }

    static class A implements Runnable {

        @Override
        public void run() {
            logger.info("it's just a A");
        }
    }

    static class B implements Runnable {

        @Override
        public void run() {
            logger.info("it's just a B");
        }
    }

}


