package com.mj;

import com.mj.list.List;

public class Stack<E> {

    private List<E> list;

    public int size() {
        return list.size();
    }

    public void clear() {
        list.clear();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void push(E element) {
        list.add(element);
    }

    public E pop() {
        return list.remove(size() - 1);
    }

    public E top() {
        return list.get(size() - 1);
    }
}
