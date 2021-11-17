/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

import java.util.PriorityQueue;

/**
 * SlideWindowMaxValue
 * <a href="https://leetcode-cn.com/problems/sliding-window-maximum/"/>
 *
 * @author guoxing
 * @date 2021/11/17 10:17 PM
 * @since
 */
public class SlideWindowMaxValue {
    /**
     * 使用优先队列,大顶堆的方式实现获取窗口最大值
     * <p>当窗口移动时需要判断上一个窗口的最大值是否在当前窗口的范围内,对于不在新窗口范围内堆中的元素要进行移除操作</p>
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 队列中存储当前窗口的最大值索引
        // 构建大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> Integer.compare(nums[o2], nums[o1])));
        // 首先插入第一个窗口
        for (int i = 0; i < k; i++) {
            queue.offer(i);
        }
        int[] results = new int[nums.length - k + 1];
        // 获取第一个窗口的最大值
        results[0] = nums[queue.peek()];
        // 开始从第一个窗口移动
        for (int i = k; i < nums.length; i++) {
            queue.offer(i);
            // 判断上一个窗口的最大索引位置是否在当前窗口区间内
            int currentWindowStartIndex = i - k + 1;
            // 由于在窗口滑动过程中可能存在已经划过的窗口元素,且如果非当前窗口的元素为最大值属于脏数据,因此需要全部排除,直到当前窗口的最大值元素在当前窗口内才可以
            while (!queue.isEmpty() && queue.peek() < currentWindowStartIndex) {
                queue.poll();
            }
            results[currentWindowStartIndex] = nums[queue.peek()];
        }
        return results;
    }
}
