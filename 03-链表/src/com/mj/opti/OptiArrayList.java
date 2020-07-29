package com.mj.opti;

import com.mj.AbstractList;

public class OptiArrayList<E> extends AbstractList<E> {
    /**
     * 所有的元素
     */
    private E[] elements;

    private int first = 0;

    private static final int DEFAULT_CAPACITY = 10;

    public OptiArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public OptiArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index(index)];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E old = elements[index(index)];
        elements[index(index)] = element;
        return old;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);

        if (index < (size >> 1)) {
            for (int i = 0; i < index; i++) {
                elements[index(i-1)] = elements[index(i)];
            }
            first--;
            if (first < 0) {
                first += elements.length;
            }
        } else {
            for (int i = size; i > index; i--) {
                elements[index(i)] = elements[index(i - 1)];
            }
        }
        elements[index(index)] = element;
        size++;
    }

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        rangeCheck(index);
        E old = elements[index];

        if (index < (size >> 1)) {
            for (int i = index; i > 0; i--) {
                elements[index(i)] = elements[index(i-1)];
            }
            elements[first] = null;
            first++;
            if (first >= elements.length) {
                first -= elements.length;
            }
            size--;
        } else {
            for (int i = index; i < size; i++) {
                elements[index(i)] = elements[index(i + 1)];
            }
            elements[index(--size)] = null;
        }

        return old;
    }

    public void remove(E element) {
        remove(indexOf(element));
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[index(i)] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[index(i)])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 保证要有capacity的容量
     *
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) {
            return;
        }

        // 新容量为旧容量的1.5倍。位运算，右移就是/2，效率高
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;

//        System.out.println(oldCapacity + "扩容为：" + newCapacity);
    }

    private int index(int index) {
        int realIndex = first + index;
        if (realIndex < 0) {
            realIndex += elements.length;
        }
        if (realIndex >= elements.length) {
            realIndex -= elements.length;
        }
        return realIndex;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Array:[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                builder.append(elements[index(i)]);
            } else {
                builder.append(elements[index(i)]).append(",");
            }
        }
        builder.append("]");
        builder.append(";First:").append(first);
        return builder.toString();
    }
}
