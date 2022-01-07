package algorithm.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-closest-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1711_单词距离 {

	public int findClosest(String[] words, String word1, String word2) {
		Map<String, List<Integer>> map=new HashMap<>();
		for (int i=0;i<words.length;i++){
			if (map.containsKey(words[i])){
				List<Integer> mid=map.get(words[i]);
				mid.add(i);
				map.put(words[i],mid);
			}
			else{
				List<Integer> mid=new ArrayList<>();
				mid.add(i);
				map.put(words[i],mid);
			}
		}
		List<Integer> w1=map.get(word1);//记录第一个单词的所有位置
		List<Integer> w2=map.get(word2);//记录第二个单词的所有位置
		int i=0;//第一个单词的位置索引
		int j=0;//第二个单词的位置索引
		int min=Math.abs(w1.get(0)-w2.get(0));
		while(i<w1.size() && j<w2.size()){
			int gap=w1.get(i)-w2.get(j);
			if (Math.abs(gap) < min) {

				min = Math.abs(gap);
			}
			if (gap >= 0) {

				j++;
			} else {
				i++;
			}
		}
		return min;
	}



}
