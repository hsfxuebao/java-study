package offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class O_64_数据流中的中位数 {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });

    int count = 0;

    /**
     * 奇数的时候，从大顶对获取中位数。
     * 4 3 2 1   大顶堆
     * 5 6 7 8   小顶对（从左往右）
     *
     * 再加入6，大于小顶堆的5，因此小顶堆变成5 6 6 7 8
     * 再把小顶堆的数据以到大顶对，我们中位数都从大顶对取
     * 5 4 3 2 1 大顶堆
     * 6 6 7 8   小顶堆
     *
     * 获取中位数为5
     * @param num
     */
    @SuppressWarnings("JavaDoc")
    public void Insert(Integer num) {
        count++;

        if (count % 2 == 1) {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.add(num);
                num = minHeap.poll();
            }
            maxHeap.add(num);
        } else {
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) {
                maxHeap.add(num);
                num = maxHeap.poll();
            }
            minHeap.add(num);
        }
    }

    public Double GetMedian() {
        if (count == 0) {
            return null;
        }
        if (count % 2 == 1) {
            return Double.valueOf(maxHeap.peek());
        } else {
            return Double.valueOf((maxHeap.peek() + minHeap.peek()) / 2.0);
        }
    }
}