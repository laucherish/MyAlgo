package 树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个 N 叉树，返回其节点值的后序遍历。
 *
 * 例如，给定一个 3叉树 :
 *         1
 *     3   2   4
 *   5  6
 *
 *
 *  
 *
 * 返回其后序遍历: [5,6,3,2,4,1].
 *
 *  
 *
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _590_N叉树的后序遍历 {
    public List<Integer> postorder(Node root) {
        List<Integer> output = new ArrayList<>();
        if (root == null) {
            return output;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = queue.size();
        while (!queue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                for (Node child : node.children) {
                    queue.offer(child);
                }
                levelList.add(node.val);
            }
            levelSize = queue.size();
            output.addAll(0, levelList);
        }
        return output;
    }
}
