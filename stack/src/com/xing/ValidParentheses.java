/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * ValidParentheses
 * <a href="https://leetcode-cn.com/problems/valid-parentheses/"/>
 *
 * @author guoxing
 * @date 2021/11/14 8:58 PM
 * @since
 */
public class ValidParentheses {

    /**
     * 利用栈的特性以及字符串长度只能为偶数
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        List<Character> rights = Arrays.asList(')', ']', '}');
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (deque.isEmpty()) {
                if (rights.contains(c)) {
                    return false;
                }
                deque.addFirst(c);
                continue;
            } else {
                if (rights.contains(c)) {
                    Character f = deque.removeFirst();
                    if (f.equals('(') && c == ')'
                            || f.equals('[') && c == ']'
                            || f.equals('{') && c == '}') {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    deque.addFirst(c);
                }
            }
        }
        return deque.isEmpty();
    }
}
