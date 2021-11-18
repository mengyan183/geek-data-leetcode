/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing.middle_search;

/**
 * SqrtX
 * <a href="https://leetcode-cn.com/problems/sqrtx/" />
 *
 * @author guoxing
 * @date 2021/11/18 9:21 PM
 * @since
 */
public class SqrtX {
    public static void main(String[] args) {
        new SqrtX().mySqrt(4);

    }

    /**
     * 对于二分查找的重点在于边界范围,以及中止条件
     * <p>对于当前题目求平方根,首先默认边界值为[0,x];</p>
     * <p>对于终止条件,当前要求x的平方根为近似符合条件的最大正整数</p>
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        int l = 0;
        int r = x;
        int result = -1;
        while (l <= r) {
            int middle = (r - l) / 2 + l;
            // 避免越界超过int的范围
            long mm = (long) middle * middle;
            if (mm <= x) {
                // 将可能符合条件的结果赋值给 最终结果
                result = middle;
                // 左侧指针右移
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return result;
    }
}
