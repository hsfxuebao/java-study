package redis6.distributelock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import redis.clients.jedis.Jedis;

/**
 * @auther hsfxuebao
 * @create 2022-01-20 14:48
 */
@RestController
public class GoodController {

    private static final String GOOD_KEY = "goods:001";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/buy_goods")
    public String buy_Goods() {


        String result = stringRedisTemplate.opsForValue().get(GOOD_KEY);
        int goodsNumber = result == null ? 0 : Integer.parseInt(result);

        if(goodsNumber > 0) {
            int realNumber = goodsNumber - 1;
            stringRedisTemplate.opsForValue().set(GOOD_KEY, String.valueOf(realNumber));
            System.out.println("你已经成功秒杀商品，此时还剩余：" + realNumber + "件");
            return "你已经成功秒杀商品，此时还剩余：" + realNumber + "件";
        }else{
            System.out.println("商品已经售罄/活动结束/调用超时，欢迎下次光临");
        }

        return "商品已经售罄/活动结束/调用超时，欢迎下次光临";
    }
}