package 剑指;

import java.util.HashMap;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *  
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 剑指07重建二叉树 {

    HashMap<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, 0, inorder.length - 1);
    }

    private TreeNode helper(int preRoot, int inLeft, int inRight) {
        if (inLeft > inRight) return null;
        int rootVal = preorder[preRoot];
        int rootIndex = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = helper(preRoot + 1, inLeft, rootIndex - 1);
        root.right = helper(preRoot + rootIndex - inLeft + 1, rootIndex + 1, inRight);
        return root;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        int val = preorder[0];
        int indexIn = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (val == inorder[i]) {
                indexIn = i;
                break;
            }
        }
        int[] preLeft = new int[indexIn];
        int[] preRight = new int[inorder.length - indexIn - 1];
        int[] inLeft = new int[indexIn];
        int[] inRight = new int[inorder.length - indexIn - 1];

        for (int i = 0; i < inorder.length; i++) {
            if (i < indexIn) {
                inLeft[i] = inorder[i];
            } else if (i > indexIn) {
                inRight[i - indexIn - 1] = inorder[i];
            }
        }

        for (int i = 1; i < preorder.length; i++) {
            if (i < preLeft.length + 1) {
                preLeft[i - 1] = preorder[i];
            } else if (i >= preLeft.length + 1) {
                preRight[i - preLeft.length - 1] = preorder[i];
            }
        }

        TreeNode node = new TreeNode(val);
        node.left = buildTree(preLeft, inLeft);
        node.right = buildTree(preRight, inRight);

        return node;
    }
}
