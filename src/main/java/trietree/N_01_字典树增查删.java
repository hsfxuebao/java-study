package trietree;

import common.TrieNode;

/**
 * @author haoshaofei
 * @date 2020/03/17
 *
 * 前缀数的增加、查找和删除
 */
public class N_01_字典树增查删 {


	public static class Trie {

		private TrieNode root;

		public Trie() {

			root = new TrieNode();
		}

		/**
		 * 字典树加入的过程
		 */
		public void insert(String word) {

			if (word == null) {
				return;
			}
			char[] chars = word.toCharArray();
			TrieNode node = root;

			int index = 0;
			for (int i = 0; i < chars.length; i++) {
				index = chars[i] - 'a';
				if (node.nexts[index] == null) {
					node.nexts[index] = new TrieNode();
				}
				node = node.nexts[index];
				node.path++;
			}

			node.end++;

		}

		/**
		 * 从字典树内删除一个单词
		 */
		public void delete(String word) {

			if (search(word) != 0) {

				if (word == null) {
					return;
				}
				char[] chars = word.toCharArray();
				int index = 0;
				TrieNode node = root;

				for (int i = 0; i < chars.length; i++) {

					index = chars[i] - 'a';
					if (--node.nexts[index].path == 0) {
						node.nexts[index] = null;
						return;
					}
					node = node.nexts[index];
				}
				node.end--;
			}

		}

		/**
		 * 查询一个单词是否在这个字典树内
		 *
		 */
		public int search(String word) {

			if (word == null) {
				return 0;
			}

			char[] chars = word.toCharArray();
			int index = 0;
			TrieNode node = root;

			for (int i = 0; i < chars.length; i++) {
				index = chars[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.end;
		}

		/**
		 * 字典树查询以目标前缀的单词的个数
		 */
		public int prefixNumber(String word) {

			if (word == null) {
				return 0;
			}

			char[] chars = word.toCharArray();
			int index = 0;
			TrieNode node = root;

			for (int i = 0; i < chars.length; i++) {

				index = chars[i] - 'a';
				if (node.nexts[index] == null) {
					return 0;
				}
				node = node.nexts[index];
			}
			return node.path;

		}

	}

	public static void main(String[] args) {
		Trie trie = new Trie();
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuo");
		trie.insert("zuo");
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.delete("zuo");
		System.out.println(trie.search("zuo"));
		trie.insert("zuoa");
		trie.insert("zuoac");
		trie.insert("zuoab");
		trie.insert("zuoad");
		trie.delete("zuoa");
		System.out.println(trie.search("zuoa"));
		System.out.println(trie.prefixNumber("zuo"));
	}


}
