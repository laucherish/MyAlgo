package mj;

import mj.printer.BinaryTrees;
import mj.tree.AVLTree;
import mj.tree.BST;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static void test1() {
        Integer data[] = new Integer[]{
//                85, 19, 69, 3, 7, 99, 95, 2, 1, 70, 44, 58, 11, 21, 14, 93, 57, 4, 56
//                85, 19, 69, 3, 7, 99, 95
                67, 52, 92, 96, 53, 95, 13, 63, 34, 82, 76, 54, 9, 68, 39
        };
//        Integer data[] = new Integer[]{
//                13,14,15,16,17,18,19
//        };

        AVLTree<Integer> avl = new AVLTree<>();
        for (int i = 0; i < data.length; i++) {
            avl.add(data[i]);
            // 调试测试数据
//            System.out.println("[" + data[i] + "]");
//            BinaryTrees.println(avl);
//            System.out.println("---------------------------------");
        }

        for (int i = 0; i < data.length; i++) {
            avl.remove(data[i]);
            // 调试测试数据
            System.out.println("[" + data[i] + "]");
            BinaryTrees.println(avl);
            System.out.println("---------------------------------");
        }

        BinaryTrees.println(avl);
    }

    static void test2() {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 100_0000; i++) {
            data.add((int)(Math.random() * 100_0000));
        }

        BST<Integer> bst = new BST<>();
        Times.test("bst_add", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < data.size(); i++) {
                    bst.add(data.get(i));
                }
            }
        });
        Times.test("bst_contains", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < data.size(); i++) {
                    bst.contains(data.get(i));
                }
            }
        });
        Times.test("bst_remove", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < data.size(); i++) {
                    bst.remove(data.get(i));
                }
            }
        });

        AVLTree<Integer> avl = new AVLTree<>();
        Times.test("avl_add", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < data.size(); i++) {
                    avl.add(data.get(i));
                }
            }
        });
        Times.test("avl_contains", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < data.size(); i++) {
                    avl.contains(data.get(i));
                }
            }
        });
        Times.test("avl_remove", new Times.Task() {
            @Override
            public void execute() {
                for (int i = 0; i < data.size(); i++) {
                    avl.remove(data.get(i));
                }
            }
        });
    }

    public static void main(String[] args) {
        test2();
    }
}
