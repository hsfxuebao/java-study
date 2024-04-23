package redis6.distributelock.redlock;

import java.util.concurrent.TimeUnit;

import org.redisson.RedissonRedLock;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedLockController {

    public static final String CACHE_KEY_REDLOCK = "REDLOCK";

    @Autowired
    RedissonClient redissonClient1;

    @Autowired
    RedissonClient redissonClient2;

    @Autowired
    RedissonClient redissonClient3;

    @GetMapping(value = "/redlock")
    public void getlock() {
        //CACHE_KEY_REDLOCK为redis 分布式锁的key
        RLock lock1 = redissonClient1.getLock(CACHE_KEY_REDLOCK);
        RLock lock2 = redissonClient2.getLock(CACHE_KEY_REDLOCK);
        RLock lock3 = redissonClient3.getLock(CACHE_KEY_REDLOCK);

        RedissonRedLock redLock = new RedissonRedLock(lock1, lock2, lock3);
        boolean isLockBoolean;

        try {
            //waitTime 抢锁的等待时间,正常情况下 等3秒
            //leaseTime就是redis key的过期时间,正常情况下等5分钟300秒。
            isLockBoolean = redLock.tryLock(3, 300, TimeUnit.SECONDS);
//            log.info("线程{}，是否拿到锁：{} ",Thread.currentThread().getName(),isLockBoolean);
            if (isLockBoolean) {
                System.out.println(Thread.currentThread().getName()+"\t"+"---come in biz");
                //业务逻辑，忙10分钟
                try { TimeUnit.MINUTES.sleep(10); } catch (InterruptedException e) { e.printStackTrace(); }
            }
        } catch (Exception e) {
//            log.error("redlock exception ",e);
        } finally {
            // 无论如何, 最后都要解锁
            redLock.unlock();
        }


    }


}
