package algorithm.array;

import java.util.BitSet;

/**
 * @author hsfxuebao
 * @date 2020/03/28
 *
 * 给定N个人的出生年份和死亡年份，第i个人的出生年份为birth[i]，死亡年份为death[i]，实现一个方法以计算生存人数最多的年份。
 *
 * 你可以假设所有人都出生于1900年至2000年（含1900和2000）之间。如果一个人在某一年的任意时期都处于生存状态，那么他们应该被纳入那一年的统计中。例如，生于1908年、死于1909年的人应当被列入1908年和1909年的计数。
 *
 * 如果有多个年份生存人数相同且均为最大值，输出其中最小的年份。
 *
 * 示例：
 *
 * 输入：
 * birth = {1900, 1901, 1950}
 * death = {1948, 1951, 2000}
 * 输出： 1901
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/living-people-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1620_生存人数 {

	public static Integer getNumber(int[] birth, int[] death) {

		int[] count = new int[101];
		int res = 1900;
		int maxAlive = 0;
		int curAlive = 0;
		int length = birth.length;

		for (int i = 0; i < length; i++) {
			++count[birth[i] - res];
			--count[death[i] - res];
		}

		for (int i = 0; i < count.length; i++) {
			curAlive += count[i];
			if (curAlive > maxAlive) {
				maxAlive = curAlive;
				res = res + i;
			}
		}
		return res;
	}

	public static void main(String[] args) {

		int[] birth = {1900, 1901, 1950};
		int[] death = {1948, 1951, 2000};
		System.out.println(getNumber(birth, death));
	}

}
