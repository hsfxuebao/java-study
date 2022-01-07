package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/28
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 *
 * 以下是井字游戏的规则：
 *
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 *
 * 示例 1：
 *
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/tic-tac-toe-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L_面1604_井字游戏 {


	private char[][] ch_board;
	private int len;

	public String tictactoe(String[] board) {
		len = board.length;
		ch_board = new char[len][len];
		for (int i = 0; i < len; ++i) {

			ch_board[i] = board[i].toCharArray();
		}

		int X_count = 0, O_count = 0;
		for (int i = 0; i < len; ++i) {

			for (char ch : ch_board[i]) {
				if (ch == 'X') {

					++X_count;
				} else if (ch == 'O') {

					++O_count;
				}
			}
		}
		//没下满棋盘
		if (X_count + O_count < len * len) {
			if (is_win('X')) {

				return "X";
			}
			if (is_win('O')) {

				return "O";
			}
			return "Pending";
		}
		//下满棋盘
		if (is_win('X')) {

			return "X";
		}
		if (is_win('O')) {

			return "O";
		}
		return "Draw";
	}

	private boolean is_win(char ch) {
		search_row: //横向
		for (int i = 0; i < len; ++i) {
			for (int j = 0; j < len; ++j) {

				if (ch_board[i][j] != ch) {

					continue search_row;
				}
			}
			return true;
		}
		search_col: //纵向
		for (int j = 0; j < len; ++j) {
			for (int i = 0; i < len; ++i) {

				if (ch_board[i][j] != ch) {

					continue search_col;
				}
			}
			return true;
		}
		boolean found = true;
		//正对角线
		for (int i = 0; i < len; ++i) {

			if (ch_board[i][i] != ch) {
				found = false;
				break;
			}
		}
		if (found) {

			return true;
		}
		found = true;
		//逆对角线
		for (int i = 0; i < len; ++i) {

			if (ch_board[i][len - i - 1] != ch) {
				found = false;
				break;
			}
		}

		return found;
	}


}
