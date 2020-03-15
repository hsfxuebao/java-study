package hash;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author haoshaofei
 * @date 2020/03/15
 *
 *
 *   设计RandomPool结构
 *   【题目】 设计一种结构，在该结构中有如下三个功能: insert(key):将某个key加入到该结构，做到不重复加入。 delete(key):将原本在结构中的某个key移除。
 *    getRandom(): 等概率随机返回结构中的任何一个key。
 *   【要求】 Insert、delete和getRandom方法的时间复杂度都是 O(1)
 *

 */
public class N_01_RandomPool {

	public static class Pool<K> {

		private Map<K, Integer> keyIndexMap;
		private Map<Integer, K> indexKeyMap;
		private int size;

		public Pool() {
			this.keyIndexMap = Maps.newHashMap();
			this.indexKeyMap = Maps.newHashMap();
			this.size = 0;
		}

		public void insert(K key) {
			if (!this.keyIndexMap.containsKey(key)) {
				this.keyIndexMap.put(key, this.size);
				this.indexKeyMap.put(this.size++, key);
			}
		}


		public void delete(K key) {

			if (this.keyIndexMap.containsKey(key)) {
				Integer deleteIndex = this.keyIndexMap.get(key);
				int lastIndex = --this.size;
				K lastKey = this.indexKeyMap.get(lastIndex);

				this.indexKeyMap.put(deleteIndex, lastKey);
				this.keyIndexMap.put(lastKey, deleteIndex);

				this.keyIndexMap.remove(key);
				this.indexKeyMap.remove(lastIndex);
			}

		}

		public K getRandom() {
			if (this.size == 0) {
				return null;

			}
			int randomIndex = (int) (Math.random() * this.size);
			return this.indexKeyMap.get(randomIndex);
		}

	}


	public static void main(String[] args) {

		Pool<String> pool = new Pool<String>();
		pool.insert("zuo");
		pool.insert("cheng");
		pool.insert("yun");
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());
		System.out.println(pool.getRandom());

	}

}
