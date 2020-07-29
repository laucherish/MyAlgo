package com.mj;

import com.mj.circle.CircleLinkedList;
import com.mj.circle.SingleCircleLinkedList;
import com.mj.opti.OptiArrayList;

public class Main {

    static void testList(List<Integer> list) {
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);

        list.add(0, 55); // [55, 11, 22, 33, 44]
        list.add(2, 66); // [55, 11, 66, 22, 33, 44]
        list.add(list.size(), 77); // [55, 11, 66, 22, 33, 44, 77]

        list.remove(0); // [11, 66, 22, 33, 44, 77]
        list.remove(2); // [11, 66, 33, 44, 77]
        list.remove(list.size() - 1); // [11, 66, 33, 44]

        Asserts.test(list.indexOf(44) == 3);
        Asserts.test(list.indexOf(22) == List.ELEMENT_NOT_FOUND);
        Asserts.test(list.contains(33));
        Asserts.test(list.get(0) == 11);
        Asserts.test(list.get(1) == 66);
        Asserts.test(list.get(list.size() - 1) == 44);

        System.out.println(list);
    }

    static void josephus() {
        CircleLinkedList<Integer> list = new CircleLinkedList<>();
        for (int i = 1; i <= 8 ; i++) {
            list.add(i);
        }

        //  指向头结点
        list.reset();

        while (!list.isEmpty()) {
            list.next();
            list.next();
            System.out.println(list.remove());
        }

    }

    public static void main(String[] args) {
//        long test11 = System.currentTimeMillis();
//        List<Integer> list = new ArrayList2<>();
//        for (int i = 0; i < 1000; i++) {
//            list.add(i);
//        }
//        long test12 = System.currentTimeMillis();
//        System.out.println("添加用时：" + (test12 - test11));
//
//        while (list.size() > 0) {
//            list.remove(0);
//        }
//        long test13 = System.currentTimeMillis();
//        System.out.println("删除用时：" + (test13 - test12));

        testList(new OptiArrayList<>());

//        josephus();

        /**
         * gc root 对象
         * 1. 被局部变量指向的对象
         */
    }
}
