/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

/**
 * MergedKSortedList
 * <a href="https://leetcode-cn.com/problems/merge-k-sorted-lists/"/>
 *
 * @author guoxing
 * @date 2021/11/11 9:48 PM
 * @since
 */
public class MergedKSortedList {

    public ListNode mergeKListNode(ListNode[] listNodes) {
        ListNode result = null;
        for (int i = 0; i < listNodes.length; i++) {
            result = mergeTwoListNode(result, listNodes[i]);
        }
        return result;
    }

    /**
     * 将 合并 k个链表先简化为合并两个链表
     * <p>1:维护一个头节点为空的链表</p>
     * <p>2:创建两个指针(head,tail)指向当前头节点为空的链表,其中head不会移动,tail指向下一个待插入节点位置</p>
     * <p>3:分别创建指针指向参数</p>
     * <p>4:遍历两个指向参数的指针,对比两个指针指向的节点的元素,数据小的节点放置到tail位置,参数指针后移一位,tail指针同样后移</p>
     * <p>5:直到两个指向参数的指针其中一个为null结束遍历,将不为空的参数指针追加到tail位置</p>
     *
     * @param a
     * @param b
     * @return
     */
    public ListNode mergeTwoListNode(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a == null ? b : a;
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        ListNode aPtr = a;
        ListNode bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val <= bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = aPtr == null ? bPtr : aPtr;
        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
