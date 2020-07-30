package 树;

import java.util.Stack;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _114_二叉树展开为链表 {
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return;
        }
        if (root.right != null) {
            stack.push(root.right);
        }
        if (root.left != null) {
            stack.push(root.left);
        }
        TreeNode curr = root;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            curr.left = null;
            curr.right = node;
            curr = node;
        }
    }
}
