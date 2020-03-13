package newcoder.high.c06;

import java.util.*;

/**
 *
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角 落)。请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 *
 */
public class Problem04_CoverMax {

	public static class Rectangle {
		public int up;
		public int down;
		public int left;
		public int right;

		public Rectangle(int up, int down, int left, int right) {
			this.up = up;
			this.down = down;
			this.left = left;
			this.right = right;
		}

	}

	public static class DownComparator implements Comparator<Rectangle> {
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return o1.down - o2.down;
		}
	}

	public static class LeftComparator implements Comparator<Rectangle> {
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return o1.left - o2.left;
		}
	}

	public static class RightComparator implements Comparator<Rectangle> {
		@Override
		public int compare(Rectangle o1, Rectangle o2) {
			return o1.right - o2.right;
		}
	}

	public static int maxCover(Rectangle[] recs) {
		if (recs == null || recs.length == 0) {
			return 0;
		}
		Arrays.sort(recs, new DownComparator());
		TreeSet<Rectangle> leftOrdered = new TreeSet<>(new LeftComparator());
		int ans = 0;
		for (int i = 0; i < recs.length; i++) {
			int curDown = recs[i].down;
			int index = i;
			while (recs[index].down == curDown) {
				leftOrdered.add(recs[index]);
				index++;
			}
			i = index;
			removeLowerOnCurDown(leftOrdered, curDown);
			TreeSet<Rectangle> rightOrdered = new TreeSet<>(new RightComparator());
			for (Rectangle rec : leftOrdered) {
				removeLeftOnCurLeft(rightOrdered, rec.left);
				rightOrdered.add(rec);
				ans = Math.max(ans, rightOrdered.size());
			}
		}
		return ans;
	}

	public static void removeLowerOnCurDown(TreeSet<Rectangle> set, int curDown) {
		List<Rectangle> removes = new ArrayList<>();
		for (Rectangle rec : set) {
			if (rec.up <= curDown) {
				removes.add(rec);
			}
		}
		for (Rectangle rec : removes) {
			set.remove(rec);
		}
	}

	public static void removeLeftOnCurLeft(TreeSet<Rectangle> rightOrdered, int curLeft) {
		List<Rectangle> removes = new ArrayList<>();
		for (Rectangle rec : rightOrdered) {
			if (rec.right > curLeft) {
				break;
			}
			removes.add(rec);
		}
		for (Rectangle rec : removes) {
			rightOrdered.remove(rec);
		}
	}

}
