package algorithm.trietree;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hsfxuebao
 * @date 2020/03/17
 *
 * 一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目 的宣讲。 给你每一个项目开始的时间和结束的时间(给你一个数 组，里面 是一个个具体的项目)，
 *  你来安排宣讲的日程，要求会 议室进行 的宣讲的场次最多。返回这个最多的宣讲场次。
 *
 *
 */
public class N_03_会议室最大宣讲数量 {

	public static class Program {
		public int start;
		public int end;

		public Program(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	//以会议室结束的时间排序
	public static class ProgramComparator implements Comparator<Program> {

		@Override
		public int compare(Program o1, Program o2) {
			return o1.end - o2.end;
		}

	}

	public static int bestArrange(Program[] programs, int start) {
		Arrays.sort(programs, new ProgramComparator());
		int result = 0;
		for (int i = 0; i < programs.length; i++) {
			if (start <= programs[i].start) {
				result++;
				start = programs[i].end;
			}
		}
		return result;
	}

	public static void main(String[] args) {


	}

}
