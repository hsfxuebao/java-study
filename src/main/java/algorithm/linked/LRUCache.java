package algorithm.linked;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.ValidationEvent;

import org.w3c.dom.Node;

import ionio.testreactor.MainThread;

/**
 * @author hsfxuebao
 * Created on 2022-02-08
 */
public class LRUCache {
    // map负责查找，构建一个虚拟的双向链表，它里面就是一个一个的Node节点，作为数据载体


    // 构造一个Node节点，作为数据载体
    class Node<K, V> {
        K key;
        V value;
        Node<K, V> prev;
        Node<K, V> next;

        public Node() {
            this.prev = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.prev = this.next = null;
        }
    }

    class DoubleLinkedList<K, V> {

        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedList() {
            this.head = new Node<>();
            this.tail = new Node<>();
            head.next = tail;
            tail.prev = head;
        }

        // 添加数据到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        // 删除一个节点
        public void removeNode(Node<K, V> node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        // 获取最后一个节点
        public Node getLast() {
            return tail.prev;
        }
    }

    private int cacheSize;
    private Map<Integer, Node<Integer, Integer>> map;
    private DoubleLinkedList<Integer, Integer> doubleLinkedList;

    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        this.map = new HashMap<>();;
        this.doubleLinkedList = new DoubleLinkedList<>();
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }
    // saveOrUpdate方法
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            // 更新
            Node<Integer, Integer> node = map.get(key);
            doubleLinkedList.removeNode(node);
            node.value = value;
            map.put(key, node);


            doubleLinkedList.addHead(node);
        } else {
            if (map.size() >= cacheSize) {
                // 删除最后一个节点
                Node lastNode = doubleLinkedList.getLast();
                map.remove(lastNode.key);
                doubleLinkedList.removeNode(lastNode);
            }
            // 增加一个节点
            Node<Integer, Integer> node = new Node<>(key, value);
            map.put(key, node);
            doubleLinkedList.addHead(node);
        }

    }

    public static void main(String[] args) {

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.map.keySet());

        lruCache.put(4, 4);
        System.out.println(lruCache.map.keySet());

        lruCache.put(3, 1);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 1);
        System.out.println(lruCache.map.keySet());
        lruCache.put(3, 1);
        System.out.println(lruCache.map.keySet());

        lruCache.put(5, 1);
        System.out.println(lruCache.map.keySet());

    }
    /**
     * false
     * [1, 2, 3]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [2, 3, 4]
     * [3, 4, 5]
     */

}
