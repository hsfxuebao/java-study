package leetcode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 *
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 示例:
 * LRUCache cache = new LRUCache( 2 );
 *
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 *
 */
public class X_146_LRU缓存机制 {

}


class LRUCache {

    private final Map<Integer, DLinkedNode> lru = new ConcurrentHashMap<>();

    private int count;
    private int capacity;

    private DLinkedNode head;
    private DLinkedNode tail;

    public LRUCache(int capacity) {
        this.count = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();

        head.pre = null;
        head.post = tail;

        tail.pre = head;
        tail.post = null;
    }

    public int get(int key) {
        DLinkedNode node = lru.get(key);
        if (node == null) {
            return -1;
        }

        this.removeToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = lru.get(key);

        if (node != null) {
            node.value = value;
            this.removeToHead(node);
        } else {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;

            this.addNode(node);
            lru.put(key, node);
            count++;

            if (count > capacity) {
                DLinkedNode tail = this.popTailNode();
                lru.remove(tail.key);
                count--;
            }
        }
    }


    private void addNode(DLinkedNode node) {
        node.pre = head;
        node.post = head.post;

        head.post.pre = node;
        head.post = node;
    }

    private void deleteNode(DLinkedNode node) {
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }

    private void removeToHead(DLinkedNode node) {
        this.deleteNode(node);
        this.addNode(node);
    }

    private DLinkedNode popTailNode() {
        DLinkedNode res = tail.pre;
        this.deleteNode(res);
        return res;
    }

    private class DLinkedNode {
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode post;
    }
}