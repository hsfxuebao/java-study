package algorithm.dynamic;

import java.util.HashSet;

/**
 * @author hsfxuebao
 * @date 2020/03/17
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab
 *  打印一个字符串的全部排列
 *  打印一个字符串的全部排列，要求不要出现重复的排列
 *
 */
public class N_04_字符串全部排列 {

	public static void printAllPermutations1(String str) {
		char[] chs = str.toCharArray();
		process1(chs, 0);
	}

	public static void process1(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		for (int j = i; j < chs.length; j++) {
			//当其他的位置都控制住之后，用来交换剩下两位的位置，并打印出可能性
			swap(chs, i, j);
			process1(chs, i + 1);
			//交换到首位及其之后位，用来固定,恢复原位
			swap(chs, i, j);
		}
	}

	public static void printAllPermutations2(String str) {
		char[] chs = str.toCharArray();
		process2(chs, 0);
	}

	public static void process2(char[] chs, int i) {
		if (i == chs.length) {
			System.out.println(String.valueOf(chs));
		}
		HashSet<Character> set = new HashSet<>();
		for (int j = i; j < chs.length; j++) {
			if (!set.contains(chs[j])) {
				set.add(chs[j]);
				swap(chs, i, j);
				process2(chs, i + 1);
				swap(chs, i, j);
			}
		}
	}

	public static void swap(char[] chs, int i, int j) {
		char tmp = chs[i];
		chs[i] = chs[j];
		chs[j] = tmp;
	}

	public static void main(String[] args) {
		String test1 = "abc";
		printAllPermutations1(test1);
		System.out.println("======");
		printAllPermutations2(test1);
		System.out.println("======");

		String test2 = "acc";
		printAllPermutations1(test2);
		System.out.println("======");
		printAllPermutations2(test2);
		System.out.println("======");
	}

}
