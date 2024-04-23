package algorithm.linked;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2022-02-08
 */
public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    // 容量
    private int capacity;

    /**
     * the ordering mode
     * <tt>true</tt> for access-order,
     * <tt>false</tt> for insertion-order

     */
    public LRUCacheDemo(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Entry<K, V> eldest) {
        return super.size() > capacity;
    }
    public static void main(String[] args) {

        LRUCacheDemo lruCache = new LRUCacheDemo(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.keySet());

        lruCache.put(4, 4);
        System.out.println(lruCache.keySet());

        lruCache.put(3, 1);
        System.out.println(lruCache.keySet());
        lruCache.put(3, 1);
        System.out.println(lruCache.keySet());
        lruCache.put(3, 1);
        System.out.println(lruCache.keySet());

        lruCache.put(5, 1);
        System.out.println(lruCache.keySet());

    }

    /*
     true
    [1, 2, 3]
    [2, 3, 4]
    [2, 4, 3]
    [2, 4, 3]
    [2, 4, 3]
    [4, 3, 5]

     false
    [1, 2, 3]
    [2, 3, 4]
    [2, 3, 4]
    [2, 3, 4]
    [2, 3, 4]
    [3, 4, 5]
     */
}
