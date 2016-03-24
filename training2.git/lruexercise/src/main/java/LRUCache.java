
import java.util.LinkedHashMap;
import java.util.Collection;
import java.util.Map;
import java.util.ArrayList;

/**
 * Created by gongxijun on 16-3-13.
 * 泛型
 */
public class LRUCache<K, V> {

    //默认Chache大小
    private static final Integer DEFAULT_SIZE = 10;
    private static final float HASHTABLE_FACTOR = 0.75f;
    private Integer cacheSize;

    private LinkedHashMap<K, V> LMap;


    /**
     * @param cacheSize 缓存尺寸
     */
    public LRUCache(Integer cacheSize) {

        this.cacheSize = cacheSize;
        Integer hashTableCapacity = (int) Math.ceil((cacheSize / HASHTABLE_FACTOR) + 1);
        LMap = new LinkedHashMap<K, V>(hashTableCapacity, HASHTABLE_FACTOR, true) {

            private static final long serialVersionUID = 1;

            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                //判断是否删除了边缘元素
                return size() > LRUCache.this.cacheSize;
            }
        };

    }


    /**
     * @param key 键值
     * @return 依据Key返回Cache的键值valuel
     */

    public synchronized V get(K key) {
        return LMap.get(key);
    }


    /**
     * @return Cache当前录入的数据内容
     */
    public synchronized Collection<Map.Entry<K, V>> getAll() {

        return new ArrayList<Map.Entry<K, V>>(LMap.entrySet());
    }

    /**
     * 功能： 添加数据
     *
     * @param key　　缓存数据的编码
     * @param value 缓存数据的权值
     */
    public synchronized void put(K key, V value) {

        LMap.put(key, value);
    }

    /**
     * 清除Cache
     */
    public synchronized void clear() {
        LMap.clear();
    }

    /**
     * 功能： 已经记录的数据
     *
     * @return 返回在Cache中的数据个数
     */

    public synchronized Integer usedEntries() {
        return LMap.size();
    }


}

