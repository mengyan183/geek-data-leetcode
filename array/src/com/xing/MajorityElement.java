/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

import java.util.Arrays;

/**
 * MajorityElement
 * <a href="https://leetcode-cn.com/problems/majority-element/"/>
 *
 * @author guoxing
 * @date 2021/11/9 8:40 PM
 * @since
 */
public class MajorityElement {
    public static void main(String[] args) {

        int mole = new MajorityElement().majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
        System.out.println(mole);

    }

    public int majorityElement(int[] nums) {
        return mole(nums);
    }

    /**
     * 第一想法,先排序然后取中间值
     *
     * @param nums
     * @return
     */
    public int sort(int[] nums) {
        // 首先进行排序,保证数据的有序性
        Arrays.sort(nums);
        // 且由于数组中的数据可以保证总是存在多数元素,因此直接返回中位数即可
        return nums[nums.length / 2];
    }

    /**
     * 通过摩尔投票选择多数的方式,并且利用少数中的多数来得到最终多数
     *
     * @param nums
     * @return
     */
    public int mole(int[] nums) {
        //摩尔投票法,假设多数元素的票分为1,其他元素票分为-1,则最终投票结果肯定是大于0的
        int majorityElement = nums[0];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (majorityElement == nums[i]) {
                count++;
            } else {
                count--;
                // 当count 为 0时,表示已经遍历过的元素中无法直接选出多数元素,因此从下个位置开始,重新开始新的遍历
                if (count == 0) {
                    // 由于肯定存在多数元素,因此不需要考虑数组越界的问题
                    majorityElement = nums[i + 1];
                }
            }
        }
        return majorityElement;
    }
}
