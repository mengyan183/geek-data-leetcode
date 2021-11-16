/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * EvaluateReversePolishNotation
 * <a href="https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/"/>
 *
 * @author guoxing
 * @date 2021/11/16 7:20 PM
 * @since
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Deque<Integer> nums = new LinkedList<>();
        List<String> ops = Arrays.asList("+", "-", "*", "/");
        for (String s : tokens) {
            if (ops.contains(s)) {
                int i2 = nums.pop();
                int i1 = nums.pop();
                if ("+".equals(s)) {
                    nums.push(i1 + i2);
                } else if ("-".equals(s)) {
                    nums.push(i1 - i2);
                } else if ("*".equals(s)) {
                    nums.push(i1 * i2);
                } else if ("/".equals(s)) {
                    nums.push(i1 / i2);
                }
            } else {
                int i = Integer.parseInt(s);
                nums.push(i);
            }
        }
        return nums.pop();
    }


}
