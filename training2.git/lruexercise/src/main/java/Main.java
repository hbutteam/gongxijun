import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Created by gongxijun on 16-3-13.
 */
public class Main {


    static  final Logger log = LoggerFactory.getLogger( Main.class );

    public static void main(String[] args) {
        LRUCache<Integer, String> lru = new LRUCache<Integer, String>(4);

        lru.put(1, "hansuo");
        lru.put(1, "hansuo");
        lru.put(3, "liuxiaoyi");
        lru.put(1, "hansuo");
        lru.put(5, "huangwenbing");
        lru.put(6, "yunfengyang");


        for (Map.Entry<Integer, String> e : lru.getAll())
            log.info(e.getKey() + " : " + e.getValue());
    }

}
