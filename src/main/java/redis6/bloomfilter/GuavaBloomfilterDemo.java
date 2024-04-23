package redis6.bloomfilter;

import java.util.ArrayList;
import java.util.List;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @auther hsfxuebao
 * @create 2022-01-20 16:43
 */
public class GuavaBloomfilterDemo {

    public static final int _1W = 10000;
    //布隆过滤器里预计要插入多少数据
    public static int size = 100 * _1W;
    //误判率,它越小误判的个数也就越少(思考，是不是可以设置的无限小，没有误判岂不更好)
    public static double fpp = 0.01;

    /**
     * helloworld入门
     */
    public void bloomFilter() {
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 100);
        // 判断指定元素是否存在
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));
        // 将元素添加进布隆过滤器
        filter.put(1);
        filter.put(2);
        System.out.println(filter.mightContain(1));
        System.out.println(filter.mightContain(2));

    }

    /**
     * 误判率演示+源码分析
     */
    public void bloomFilter2() {
        // 构建布隆过滤器
        BloomFilter<Integer> bloomFilter = BloomFilter.create(Funnels.integerFunnel(),size,fpp);

        //1 先往布隆过滤器里面插入100万的样本数据
        for (int i = 0; i < size; i++) {
            bloomFilter.put(i);
        }
       /* List<Integer> listSample = new ArrayList<>(size);
        //2 这100万的样本数据，是否都在布隆过滤器里面存在？
        for (int i = 0; i < size; i++)
        {
            if (bloomFilter.mightContain(i)) {
                listSample.add(i);
                continue;
            }
        }
        System.out.println("存在的数量：" + listSample.size());*/

        //3 故意取10万个不在过滤器里的值，看看有多少个会被认为在过滤器里,误判率演示
        List<Integer> list = new ArrayList<>(10 * _1W);

        for (int i = size+1; i < size + 100000; i++) {
            if (bloomFilter.mightContain(i)) {
                System.out.println(i+"\t"+"被误判了.");
                list.add(i);
            }
        }
        System.out.println("误判的数量：" + list.size());
    }

    public static void main(String[] args) {

        new GuavaBloomfilterDemo().bloomFilter();
    }
}
