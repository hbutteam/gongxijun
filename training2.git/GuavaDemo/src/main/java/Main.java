
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by gongxijun on 16-3-15.
 */

public class Main {

    static Logger  logger ;
    static
    {
      logger = LoggerFactory.getLogger( Main.class );
    }

    private static  boolean ready ;
    private static  Integer  number ;
    private static class ReaderThread extends Thread {

        public void run(){
            while (!ready)
                Thread.yield();
            logger.info(String.valueOf(number));
        }

    }

    public static  void main(String [] arg){

        new ReaderThread().start();
        new ReaderThread().start();
        number = 43;
        ready = true;


    }


}
