package redis6.distributelock.watchdog;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * @auther hsfxuebao
 * @create 2021-12-24 15:45
 */
public class WatchDogDemo {
    public static final String LOCKKEY = "AAA";

    private static Config config;
    private static Redisson redisson;

    static {
        config = new Config();
        config.useSingleServer().setAddress("redis://"+"192.168.111.147"+":6379").setDatabase(0);
        redisson = (Redisson)Redisson.create(config);
    }

    public static void main(String[] args) {
        RLock redissonLock = redisson.getLock(LOCKKEY);

        redissonLock.lock();
        try {
            System.out.println("1111-------biz");
            //暂停几秒钟线程
            try { TimeUnit.SECONDS.sleep(25); } catch (InterruptedException e) { e.printStackTrace(); }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(redissonLock.isLocked() && redissonLock.isHeldByCurrentThread())
            {
                redissonLock.unlock();
            }
        }

        System.out.println(Thread.currentThread().getName() + " main ------ ends.");

        //暂停几秒钟线程
        try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
        redisson.shutdown();
    }
}
