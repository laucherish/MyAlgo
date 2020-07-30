package 树;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _106_从中序与后序遍历序列构造二叉树 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        int rootVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(rootVal);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (rootVal == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        int[] inorderLeft = new int[rootIndex];
        int[] inorderRight = new int[inorder.length - rootIndex - 1];
        for (int i = 0; i < inorder.length; i++) {
            if (i < rootIndex) {
                inorderLeft[i] = inorder[i];
            }
            if (i > rootIndex) {
                inorderRight[i - rootIndex - 1] = inorder[i];
            }
        }

        int[] postorderLeft = new int[inorderLeft.length];
        int[] postorderRight = new int[inorderRight.length];
        for (int i = 0; i < postorder.length-1; i++) {
            if (i < postorderLeft.length) {
                postorderLeft[i] = postorder[i];
            }
            if (i >= postorderLeft.length) {
                postorderRight[i - postorderLeft.length] = postorder[i];
            }
        }

        node.left = buildTree(inorderLeft, postorderLeft);
        node.right = buildTree(inorderRight, postorderRight);
        return node;
    }
}
