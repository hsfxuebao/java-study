package algorithm.array;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 *
 *  输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 *  输出：-1
 *  说明: 不存在返回-1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L_面1005_稀疏数组搜索 {

	public static int findString(String[] words, String s) {

		if (Objects.isNull(words) || StringUtils.isBlank(s)) {
			return -1;
		}

		int length = words.length;
		int left = 0;
		int right = length - 1;
		while (left <= right) {
			while (left <= right && words[left].length() == 0) {
				left++;
			}
			while (left <= right && words[right].length() == 0) {
				right--;
			}

			int mid = left + ((right - left) >> 1);
			while (mid <= right && words[mid].length() == 0) {
				mid++;
			}

			if (words[mid].equals(s)) {
				return mid;
			} else if (words[mid].compareTo(s) > 0) {
				right = mid - 1;

			} else {
				left = mid + 1;
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
		String s = "ta";
		System.out.println(findString(words, s));
	}

}
