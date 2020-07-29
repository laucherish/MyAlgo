package com.mj;

import com.sun.tools.javac.util.Assert;

public class Main {
    public static void main(String[] args) {
        int array[] = new int[]{11, 22, 33};

//        ArrayList<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 50; i++) {
//            list.add(i);
//        }
//        list.add(11);
//        list.add(22);
//        list.add(33);
//        list.add(44);
//        list.add(55);

        ArrayList<Object> persons = new ArrayList<>();
        persons.add(new Person(1,"hha"));
        persons.add(new Person(11,"haha"));
        persons.add(null);
        persons.add(new Person(2,"hhe"));
        persons.add(1);
        persons.add(1.5);

        System.out.println("Size:" + persons.size());
        System.out.println("List:" + persons);
        System.out.println("IndexOf:" + persons.indexOf(new Person(2,"hhe")));

        // 提醒垃圾回收
    }
}
