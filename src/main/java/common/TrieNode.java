package common;

/**
 * @author haoshaofei
 * @date 2020/03/17
 *
 * 字典树
 */
public class TrieNode {

	/**
	 * 表示字符路过这个节点的次数，以当前节点为前缀的字符有多少个
	 */
	public int path;
	/**
	 * 记录以当前节点结束的字符的个数
	 */
	public int end;


	public TrieNode[] nexts;

	public TrieNode() {

		path = 0;
		end = 0;
		/**
		 * 只能存英文小写字母
		 */
		nexts = new TrieNode[26];
	}


}
