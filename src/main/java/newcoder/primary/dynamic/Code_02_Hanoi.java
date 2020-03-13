package newcoder.primary.dynamic;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/7d6cab7d435048c4b05251bf44e9f185
 * 来源：牛客网
 *
 * 对于传统的汉诺塔游戏我们做一个拓展，我们有从大到小放置的n个圆盘，开始时所有圆盘都放在左边的柱子上，按照汉诺塔游戏的要求我们要把所有的圆盘都移到右边的柱子上，请实现一个函数打印最优移动轨迹。
 *
 * 给定一个int n，表示有n个圆盘。请返回一个string数组，其中的元素依次为每次移动的描述。描述格式为： move from [left/mid/right] to [left/mid/right]。
 *
 * 测试样例：
 * 1
 * 返回：move from left to right
 */
public class Code_02_Hanoi {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, n, "left", "mid", "right");
		}
	}

	public static void func(int rest, int down, String from, String help, String to) {
		if (rest == 1) {
			System.out.println("move " + down + " from " + from + " to " + to);
		} else {
			func(rest - 1, down - 1, from, to, help);
			func(1, down, from, help, to);
			func(rest - 1, down - 1, help, from, to);
		}
	}

	public static void moveLeftToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to right");
		}
		moveLeftToMid(N - 1);
		System.out.println("move " + N + "from left to right");
		moveMidToRight(N - 1);
	}

	public static void moveRightToLeft(int N) {

	}

	public static void moveLeftToMid(int N) {
		if (N == 1) {
			System.out.println("move 1 from left to mid");
		}
		moveLeftToRight(N - 1);
		System.out.println("move " + N + "from left to mid");
		moveRightToMid(N - 1);
	}

	public static void moveMidToLeft(int N) {

	}

	public static void moveRightToMid(int N) {

	}

	public static void moveMidToRight(int N) {
		if (N == 1) {
			System.out.println("move 1 from mid to right");
		}
		moveMidToLeft(N - 1);
		System.out.println("move " + N + "from mid to right");
		moveLeftToRight(N - 1);
	}

	public static void main(String[] args) {
		int n = 3;
		hanoi(n);
	}

}
