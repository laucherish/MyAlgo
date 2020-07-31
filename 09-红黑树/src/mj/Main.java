package mj;

import mj.printer.BinaryTrees;
import mj.tree.AVLTree;
import mj.tree.BST;
import mj.tree.RBTree;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void test3() {
        Integer data[] = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rbTree = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
            // 调试测试数据
            System.out.println("[" + data[i] + "]");
            BinaryTrees.println(rbTree);
            System.out.println("---------------------------------");
        }

        BinaryTrees.println(rbTree);
    }

    static void test4() {
        Integer data[] = new Integer[]{
                55, 87, 56, 74, 96, 22, 62, 20, 70, 68, 90, 50
        };

        RBTree<Integer> rbTree = new RBTree<>();
        for (int i = 0; i < data.length; i++) {
            rbTree.add(data[i]);
        }

        BinaryTrees.println(rbTree);

        for (int i = 0; i < data.length; i++) {
            rbTree.remove(data[i]);
            // 调试测试数据
            System.out.println("[" + data[i] + "]");
            BinaryTrees.println(rbTree);
            System.out.println("---------------------------------");
        }
    }

    public static void main(String[] args) {
        test4();
    }
}
