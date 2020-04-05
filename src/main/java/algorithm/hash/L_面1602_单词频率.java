package algorithm.hash;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haoshaofei
 * @date 2020/03/31
 *
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 *
 * 你的实现应该支持如下操作：
 *
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在数中出现的频率
 * 示例：
 *
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/words-frequency-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1602_单词频率 {

	private static volatile ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
	public L_面1602_单词频率(String[] books) {

		for (String book : books) {
			if (map.contains(book)) {
				map.put(book, map.get(book) + 1);
			} else {
				map.put(book, 1);
			}
		}

	}

	public static int get(String word) {

		Integer count = map.get(word);
		if (count == null) {
			return 0;
		}

		return count;
	}


	public static void main(String[] args) {

		String[] books = {"i", "have", "an", "apple", "he", "have", "a", "pen"};
		L_面1602_单词频率 test = new L_面1602_单词频率(books);
		System.out.println(get("you"));


	}
}
