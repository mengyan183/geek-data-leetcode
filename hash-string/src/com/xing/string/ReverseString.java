/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing.string;

/**
 * ReverseString
 * <a href="https://leetcode-cn.com/problems/reverse-string/submissions/"/>
 *
 * @author guoxing
 * @date 2021/11/18 9:42 PM
 * @since
 */
public class ReverseString {
    /**
     * 只需要遍历一般的字符通过和相对位置的交换就可以实现字符串的反转
     * <p>对于考虑字符串的长度是奇数还是偶数,这个并不重要</p>
     * <p>当长度为奇数时,middle为中间值的索引</p>
     * <p>当长度为偶数时,对半分之后为右侧第一个元素</p>
     * <p>这两个位置的元素都不需要被遍历到,因此作为终止条件</p>
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int l = s.length;
        int middle = s.length / 2;
        for (int i = 0; i < middle; i++) {
            char temp = s[i];
            s[i] = s[l - i - 1];
            s[l - i - 1] = temp;
        }
    }
}
