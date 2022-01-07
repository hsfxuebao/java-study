package algorithm.review;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 *
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-intervals
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_56_合并区间 {

	public static class Interval{
		public int start;
		public int end;
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}


	public static List<Interval> merge(List<Interval> intervals) {

		LinkedList<Interval> resultList = new LinkedList<>();
		if (Objects.isNull(intervals)) {
			return resultList;
		}
		int size = intervals.size();

		if (size == 1) {
			return intervals;
		}

		Collections.sort(intervals, new IntevalCompartor());

		for (Interval interval : intervals) {
			if (resultList.isEmpty() || interval.start > resultList.getLast().end) {
				resultList.addLast(interval);
			} else {
				resultList.getLast().end = Math.max(interval.end, resultList.getLast().end);
			}
		}
		return resultList;
	}

	public static class IntevalCompartor implements Comparator<Interval>{

		@Override
		public int compare(Interval o1, Interval o2) {
			return o1.start - o2.start;
		}
	}


	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(15, 18));
		List<Interval> list = merge(intervals);
		System.out.println(list);
	}
}
