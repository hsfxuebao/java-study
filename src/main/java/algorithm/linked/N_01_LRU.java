package algorithm.linked;

/**
 * @author haoshaofei
 * @date 2020/03/16
 */

import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import java.util.Map;

/**
 * 设计可以变更的缓存结构(LRU) 【题目】
 * 设计一种缓存结构，该结构在构造时确定大小，假设大小为K，并有两个功能: set(key,value):将记录(key,value)插入该结构。 get(key):返回key对应的value值。
 * 【要求】
 * 1.set和get方法的时间复杂度为O(1)。 2.某个key的set或get操作一旦发生，认为这个key的记录成了最经常使用的。
 * 3.当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的。
 * 【举例】
 * 假设缓存结构的实例是cache，大小为3，并依次发生如下行为: 1.cache.set("A",1)。最经常使用的记录为("A",1)。
 * 2.cache.set("B",2)。最经常使用的记录为("B",2)，("A",1)变为最不经常的。
 * 3.cache.set("C",3)。最经常使用的记录为("C",2)，("A",1)还是最不经常的。
 * 4.cache.get("A")。最经常使用的记录为("A",1)，("B",2)变为最不经常的。
 * 5.cache.set("D",4)。大小超过了3，所以移除此时最不经常使用的记录("B",2)， 加入记录 ("D",4)，并且为最经常使用的记录，然后("C",2)变为最不经常使用的 记录
 *
 */
public class N_01_LRU {

	public static class Node<V> {

		public V value;
		public Node<V> last;
		public Node<V> next;

		public Node(V value) {
			this.value = value;
		}

	}


	/**
	 * 链表末尾是经常访问的元素
	 * @param <V>
	 */
	public static class NodeDoubleLinkedList<V> {


		private Node<V> head;
		private Node<V> tail;

		public NodeDoubleLinkedList() {
			this.head = null;
			this.tail = null;
		}

		public void addNode(Node<V> newNode) {

			if (newNode == null) {
				return;
			}
			if (this.head == null) {
				this.head = newNode;
				this.tail = newNode;
			} else {

				this.tail.next = newNode;
				newNode.last = this.tail;
				this.tail = newNode;

			}

		}

		public void moveNodeToTail(Node<V> node) {

			if (Objects.equal(this.tail, node)) {
				return;
			}

			if (Objects.equal(this.head, node)) {
				this.head = node.next;
				this.head.last = null;
			} else {

				node.last.next = node.next;
				node.next.last = node.last;
			}

			//往末尾插入node
			node.last = this.tail;
			node.next = null;
			this.tail.next = node;
			this.tail = node;

		}

		public Node<V> removeHead() {

			if (this.head == null) {
				return null;
			}

			Node<V> res = this.head;
			if (Objects.equal(this.head, this.tail)) {
				this.head = null;
				this.tail = null;
			} else {
				this.head = res.next;
				res.next = null;
				this.head.last = null;
			}
			return res;

		}

	}

	public static class MyCache<K, V> {

		private Map<K, Node<V>> keyNodeMap;
		private Map<Node<V>, K> nodeKeyMap;
		private NodeDoubleLinkedList<V> nodeList;
		private int capacity;

		public MyCache(int capacity) {
			if (capacity < 1) {
				throw new RuntimeException("必须大于0");
			}
			this.capacity = capacity;
			this.keyNodeMap = Maps.newHashMap();
			this.nodeKeyMap = Maps.newHashMap();
			this.nodeList = new NodeDoubleLinkedList<V>();
		}

		public V get(K key) {

			if (this.keyNodeMap.containsKey(key)) {
				Node<V> res = keyNodeMap.get(key);
				this.nodeList.moveNodeToTail(res);
				return res.value;

			}
			return null;
		}


		public void set(K key, V value) {

			if (this.keyNodeMap.containsKey(key)) {
				Node<V> node = this.keyNodeMap.get(key);
				node.value = value;
				this.nodeList.moveNodeToTail(node);
			} else {

				Node<V> newNode = new Node<V>(value);
				this.keyNodeMap.put(key, newNode);
				this.nodeKeyMap.put(newNode, key);
				this.nodeList.addNode(newNode);
				if (this.keyNodeMap.size() == this.capacity + 1) {
					this.removeMostUnusedCache();
				}

			}

		}

		/**
		 * 删除不经常使用的元素
		 */
		private void removeMostUnusedCache() {

			Node<V> removeNode = this.nodeList.removeHead();
			K removeKey = this.nodeKeyMap.get(removeNode);
			this.keyNodeMap.remove(removeKey);
			this.nodeKeyMap.remove(removeNode);

		}

		public static void main(String[] args) {
			MyCache<String, Integer> testCache = new MyCache<String, Integer>(3);
			testCache.set("A", 1);
			testCache.set("B", 2);
			testCache.set("C", 3);
			System.out.println(testCache.get("B"));
			System.out.println(testCache.get("A"));
			testCache.set("D", 4);
			System.out.println(testCache.get("D"));
			System.out.println(testCache.get("C"));

		}


	}


}
