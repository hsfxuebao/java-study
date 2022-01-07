package algorithm.tree;

/**
 * @author hsfxuebao
 * @date 2020/03/23
 */
public class N_17_公司活跃度dp {


	public static int maxHappy(int[][] matrix) {
		int[][] dp = new int[matrix.length][2];
		boolean[] visited = new boolean[matrix.length];
		//找到根节点
		int root = 0;
		for (int i = 0; i < matrix.length; i++) {
			if (i == matrix[i][0]) {
				root = i;
			}
		}
		process(matrix, dp, visited, root);
		return Math.max(dp[root][0], dp[root][1]);
	}

	public static void process(int[][] matrix, int[][] dp, boolean[] visited, int root) {
		visited[root] = true;
		//他自己来的活跃度
		dp[root][1] = matrix[root][1];
		for (int i = 0; i < matrix.length; i++) {
			//找到儿子节点并且没有被遍历过
			if (matrix[i][0] == root && !visited[i]) {
				process(matrix, dp, visited, i);
				//父亲来，加上儿子不来的活跃度
				dp[root][1] += dp[i][0];
				//父亲不来，加上儿子来或者不来的最大活跃度
				dp[root][0] += Math.max(dp[i][1], dp[i][0]);
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 8 }, { 1, 9 }, { 1, 10 } };
		System.out.println(maxHappy(matrix));
	}

}
