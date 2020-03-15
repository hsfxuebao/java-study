package hash;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author haoshaofei
 * @date 2020/03/15
 * <p>
 * 合并和查找集合：https://juejin.im/post/5deb99756fb9a01600533063
 */
public class N_02_并查集 {

	public static class Node {

		//whatever you like
	}

	public static class UnionFindSet {

		public Map<Node, Node> fatherMap;
		public Map<Node, Integer> sizeMap;

		public UnionFindSet() {
			this.fatherMap = Maps.newHashMap();
			this.sizeMap = Maps.newHashMap();
		}

		//初始化所有的数据
		public void makeSets(List<Node> nodes) {

			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				this.fatherMap.put(node, node);
				this.sizeMap.put(node, 1);
			}
		}

		/**
		 * 查找一个结点的头结点并设置该节点的头结点
		 *
		 * @param node
		 * @return
		 */
		public Node findHead(Node node) {
			Node fatherNode = fatherMap.get(node);
			if (Objects.equal(fatherNode, node)) {
				fatherNode = findHead(fatherNode);
			}
			fatherMap.put(node, fatherNode);
			return fatherNode;
		}

		/**
		 * 判断两个结点是否在同一个集合中
		 *
		 * @param a
		 * @param b
		 * @return
		 */
		public boolean isSameSet(Node a, Node b) {
			return Objects.equal(findHead(a), findHead(b));
		}


		/**
		 * 合并两个集合
		 */
		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);

			if (!Objects.equal(aHead, bHead)) {

				Integer aSize = sizeMap.get(a);
				Integer bSize = sizeMap.get(b);

				if (aSize >= bSize) {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSize + bSize);
				} else {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSize + bSize);
				}
			}
		}
	}

	public static void main(String[] args) {

		//
	}
}
