package mj;

import mj.printer.BinaryTrees;
import mj.tree.AVLTree;
import mj.tree.BST;

public class Main {

    static void test1() {
        Integer data[] = new Integer[]{
                85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56
        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
        }

        BinaryTrees.println(avl);
    }

    public static void main(String[] args) {
        test1();
    }
}
