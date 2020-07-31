package mj.tree;

import java.util.Comparator;

public class RBTree<E> extends BBST<E> {
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public RBTree() {
        this(null);
    }

    public RBTree(Comparator<E> comparator) {
        super(comparator);
    }

    @Override
    protected void afterAdd(Node<E> node) {
        Node<E> parent = node.parent;

        // 添加的是根节点
        if (parent == null) {
            black(node);
            return;
        }

        // 如果父节点是黑色，直接返回
        if (isBlack(parent)) {
            return;
        }

        // 叔父节点
        Node<E> uncle = parent.sibling();
        // 祖父节点
        Node<E> grand = red(parent.parent);
        if (isRed(uncle)) { // 叔父节点是红色
            black(parent);
            black(uncle);
            // 祖父节点当作是新添加的节点
            afterAdd(grand);
            return;
        }

        // 叔父节点不是红色
        if (parent.isLeftChild()) { // L
            if (node.isLeftChild()) { // LL
                black(parent);
            } else { // LR
                black(node);
                rotateLeft(parent);
            }
            rotateRight(grand);
        } else { // R
            if (node.isLeftChild()) { // RL
                black(node);
                rotateRight(parent);
            } else { // RR
                black(parent);
            }
            rotateLeft(grand);
        }
    }

//    @Override
//    protected void afterRemove(Node<E> node, Node<E> replacement) {
//        // 如果删除的节点是红色
//        if (isRed(node)) {
//            return;
//        }
//
//        // 用以取代的是红色
//        if (isRed(replacement)) {
//            black(replacement);
//            return;
//        }
//
//        Node<E> parent = node.parent;
//        // 删除的是根节点
//        if (parent == null) {
//            return;
//        }
//
//        // 删除的是黑色叶子节点【下溢】
//        // 判断被删除的node是左还是右
//        boolean left = parent.left == null || node.isLeftChild();
//        Node<E> sibling = left ? parent.right : parent.left;
//        if (left) { // 被删除的节点在左边，兄弟节点在右边
//            if (isRed(sibling)) { // 兄弟节点是红色，转成黑色
//                black(sibling);
//                red(parent);
//                rotateLeft(parent);
//                // 更换兄弟
//                sibling = parent.right;
//            }
//            // 兄弟节点必然是黑色
//            if (isBlack(sibling.left) && isBlack(sibling.right)) {
//                // 兄弟节点没有一个红色子节点，父节点要向下和兄弟节点合并
//                boolean parentBlack = isBlack(parent);
//                black(parent);
//                red(sibling);
//                if (parentBlack) {
//                    afterRemove(parent, null);
//                }
//            } else {  // 兄弟节点至少有一个红色子节点，向兄弟节点借元素
//                // 兄弟左边是黑色，先对兄弟旋转
//                if (isBlack(sibling.right)) {
//                    rotateRight(sibling);
//                    sibling = parent.right;
//                }
//                color(sibling, colorOf(parent));
//                black(sibling.right);
//                black(parent);
//
//                rotateLeft(parent);
//            }
//        } else { // 被删除的节点在右边，兄弟节点在左边
//            if (isRed(sibling)) { // 兄弟节点是红色，转成黑色
//                black(sibling);
//                red(parent);
//                rotateRight(parent);
//                // 更换兄弟
//                sibling = parent.left;
//            }
//            // 兄弟节点必然是黑色
//            if (isBlack(sibling.left) && isBlack(sibling.right)) {
//                // 兄弟节点没有一个红色子节点，父节点要向下和兄弟节点合并
//                boolean parentBlack = isBlack(parent);
//                black(parent);
//                red(sibling);
//                if (parentBlack) {
//                    afterRemove(parent, null);
//                }
//            } else {  // 兄弟节点至少有一个红色子节点，向兄弟节点借元素
//                // 兄弟左边是黑色，先对兄弟旋转
//                if (isBlack(sibling.left)) {
//                    rotateLeft(sibling);
//                    sibling = parent.left;
//                }
//                color(sibling, colorOf(parent));
//                black(sibling.left);
//                black(parent);
//
//                rotateRight(parent);
//            }
//        }
//    }

    @Override
    protected void afterRemove(Node<E> node) {
        // 如果删除的节点是红色
//        if (isRed(node)) {
//            return;
//        }

        // 如果删除的节点是红色 或者 用以取代删除的是红色，两种情况融合
        if (isRed(node)) {
            black(node);
            return;
        }

        Node<E> parent = node.parent;
        // 删除的是根节点
        if (parent == null) {
            return;
        }

        // 删除的是黑色叶子节点【下溢】
        // 判断被删除的node是左还是右
        boolean left = parent.left == null || node.isLeftChild();
        Node<E> sibling = left ? parent.right : parent.left;
        if (left) { // 被删除的节点在左边，兄弟节点在右边
            if (isRed(sibling)) { // 兄弟节点是红色，转成黑色
                black(sibling);
                red(parent);
                rotateLeft(parent);
                // 更换兄弟
                sibling = parent.right;
            }
            // 兄弟节点必然是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // 兄弟节点没有一个红色子节点，父节点要向下和兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else {  // 兄弟节点至少有一个红色子节点，向兄弟节点借元素
                // 兄弟左边是黑色，先对兄弟旋转
                if (isBlack(sibling.right)) {
                    rotateRight(sibling);
                    sibling = parent.right;
                }
                color(sibling, colorOf(parent));
                black(sibling.right);
                black(parent);

                rotateLeft(parent);
            }
        } else { // 被删除的节点在右边，兄弟节点在左边
            if (isRed(sibling)) { // 兄弟节点是红色，转成黑色
                black(sibling);
                red(parent);
                rotateRight(parent);
                // 更换兄弟
                sibling = parent.left;
            }
            // 兄弟节点必然是黑色
            if (isBlack(sibling.left) && isBlack(sibling.right)) {
                // 兄弟节点没有一个红色子节点，父节点要向下和兄弟节点合并
                boolean parentBlack = isBlack(parent);
                black(parent);
                red(sibling);
                if (parentBlack) {
                    afterRemove(parent);
                }
            } else {  // 兄弟节点至少有一个红色子节点，向兄弟节点借元素
                // 兄弟左边是黑色，先对兄弟旋转
                if (isBlack(sibling.left)) {
                    rotateLeft(sibling);
                    sibling = parent.left;
                }
                color(sibling, colorOf(parent));
                black(sibling.left);
                black(parent);

                rotateRight(parent);
            }
        }
    }

    private Node<E> color(Node<E> node, boolean color) {
        if (node == null) {
            return null;
        }
        ((RBNode<E>) node).color = color;
        return node;
    }

    private Node<E> red(Node<E> node) {
        return color(node, RED);
    }

    private Node<E> black(Node<E> node) {
        return color(node, BLACK);
    }

    private boolean colorOf(Node<E> node) {
        return node == null ? BLACK : ((RBNode<E>) node).color;
    }

    private boolean isBlack(Node<E> node) {
        return colorOf(node) == BLACK;
    }

    private boolean isRed(Node<E> node) {
        return colorOf(node) == RED;
    }

    @Override
    protected Node<E> createNode(E element, Node<E> parent) {
        return new RBNode<>(element, parent);
    }

    private static class RBNode<E> extends Node<E> {
        // 添加节点的时候默认是红色，性质能够尽快满足，空节点是黑色
        boolean color = RED;

        public RBNode(E element, Node<E> parent) {
            super(element, parent);
        }

        @Override
        public String toString() {
            String str = "";
            if (color == RED) {
                str = "R_";
            }
            str += element;
            return str;
        }
    }
}
