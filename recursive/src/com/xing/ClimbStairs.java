/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

/**
 * ClimbStairs
 * <a href="https://leetcode-cn.com/problems/climbing-stairs/"/>
 *
 * @author guoxing
 * @date 2021/11/17 10:38 PM
 * @since
 */
public class ClimbStairs {
    /**
     * 对于爬楼梯算法
     * <p>1:递推公式为:假设存在函数 f(n) 表示n层楼梯爬的方案个数,而爬最后一次楼梯的方案存在两种  f(n-1) 一次爬一层 / f(n-2) 一次爬两层</p>
     * <p>2:对于已知的 f(1) = 1; f(2) = 2; f(3) = f(1) + f(2)</p>
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int[] results = new int[n + 1];
        results[1] = 1;
        results[2] = 2;
        for (int i = 3; i <= n; i++) {
            results[i] = results[i - 1] + results[i - 2];
        }
        return results[n];
    }
}
