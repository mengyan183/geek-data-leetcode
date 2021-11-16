/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

/**
 * DesignCircularDeque
 * <a href="https://leetcode-cn.com/problems/design-circular-deque/comments/"/>
 *
 * @author guoxing
 * @date 2021/11/16 7:53 PM
 * @since
 */
public class DesignCircularDeque {

    public static void main(String[] args) {
        MyCircularDequeV2 myCircularDequeV2 = new MyCircularDequeV2(4);

        System.out.println(myCircularDequeV2.insertFront(9));
        System.out.println(myCircularDequeV2.deleteLast());
        System.out.println(myCircularDequeV2.getRear());
    }
}

/**
 * 使用数组实现
 */
class MyCircularDequeV2 {
    private int[] values;
    private int head = -1;
    private int tail = -1;


    public MyCircularDequeV2(int k) {
        values = new int[k];
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        if (head == -1) {
            values[++head] = value;
            tail = head;
        } else {
            if (head == 0) {
                head = values.length - 1;
                values[head] = value;
            } else {
                values[--head] = value;
            }
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        if (head == -1) {
            values[++head] = value;
            tail = head;
        } else {
            if (tail == values.length - 1) {
                tail = 0;
                values[tail] = value;
            } else {
                values[++tail] = value;
            }
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        boolean flag = head == tail;
        if (head == values.length - 1) {
            head = 0;
        } else {
            head++;
        }
        if (flag) {
            head = -1;
            tail = head;
        }
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        boolean flag = head == tail;
        if (tail == 0) {
            tail = values.length - 1;
        } else {
            tail--;
        }
        if (flag) {
            tail = -1;
            head = tail;
        }
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : values[head];
    }

    public int getRear() {
        return isEmpty() ? -1 : values[tail];
    }

    public boolean isEmpty() {
        return head == -1;
    }

    public boolean isFull() {
        return (head == 0 && tail == values.length - 1) || (tail < head && head - tail == 1);
    }
}

class MyCircularDeque {
    private final int capacity;
    private int size;
    private Node head;
    private Node tail;

    class Node {
        public int v;
        public Node next;
        public Node before;

        public Node(int v) {
            this.v = v;
        }
    }

    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    public boolean insertFront(int value) {
        if (!isFull()) {
            if (head == null) {
                head = new Node(value);
                head.next = head;
                head.before = head;
                tail = head;
            } else {
                Node lh = new Node(value);
                lh.next = head;
                head.before = lh;
                tail.next = lh;
                lh.before = tail;
                head = lh;
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (!isFull()) {
            if (head == null) {
                head = new Node(value);
                head.next = head;
                head.before = head;
                tail = head;
            } else {
                Node lh = new Node(value);
                tail.next = lh;
                head.before = lh;
                lh.before = tail;
                lh.next = head;
                tail = lh;
            }
            size++;
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node nh = head.next;
            tail.next = nh;
            nh.before = tail;
            head.next = null;
            head.before = null;
            head = nh;
        }
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            Node nb = tail.before;
            nb.next = head;
            head.before = nb;
            tail.next = null;
            tail.before = null;
            tail = nb;
        }
        size--;
        return true;
    }

    public int getFront() {
        return head == null ? -1 : head.v;
    }

    public int getRear() {
        return tail == null ? -1 : tail.v;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */