/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

/**
 * FirstMissingPositive
 * <a href="https://leetcode-cn.com/problems/first-missing-positive/"/>
 *
 * @author guoxing
 * @date 2021/11/10 10:57 PM
 * @since
 */
public class FirstMissingPositive {

    /**
     * 查找数组中缺失的最小正整数
     * <p>方案1:hash表</p>
     * <p>方案2:置换法</p>
     */

    public static void main(String[] args) {

    }

    /**
     * 置换法
     * <p>遍历数组,如果遍历到的元素属于[1,N]之间,则和元素-1对应的索引位置的元素进行交换,对交换后的元素继续进行判断,直到不符合条件位置</p>
     * <p>由于数组中可能存在相同数值的元素,因此为了避免进入死循环,如果交换的元素之间数值相等则继续下一个循环</p>
     * <p>当遍历结束后,再次遍历数组,查找第一个元素值和索引+1不相等的索引,返回索引+1</p>
     */
    public int exchange(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] - 1;
            while (nums[i] <= nums.length && nums[i] >= 1 && nums[i] != nums[index]) {
                nums[i] = nums[index];
                nums[index] = index + 1;
                // 重置index
                index = nums[i] - 1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    /**
     * hash表主要是借鉴hashMap的方式,对于采用hashMap最粗暴的方式就是将数组中所有的数据作为key写入到hashMap中;
     * <p>但为了保证O1的空间复杂度,只能借助原有的数组实现</p>
     * <p>数组下标可以作为原生的key来实现hash映射的目的</p>
     * <p>对于获取数组中的最小正整数,数组长度为N,因此如果存在缺失的正整数,则肯定在[1,N]范围内,否则就为N+1</p>
     * <p>1:首先遍历数组过滤小于等于0的元素,将其变更为N+1;将其排除在缺失数据之外;此时数组中的元素都大于0</p>
     * <p>2:再次遍历数组,将在[1,N]范围内的元素取绝对值-1作为数组索引,将当前索引位置对应的元素取绝对值然后变为负数</p>
     * <p>3:再次遍历数组,将第一个大于0的数据索引+1,返回结果;否则返回N+1</p>
     *
     * @param ints
     * @return
     */
    public int hashF(int[] ints) {
        int length = ints.length;
        for (int i = 0; i < length; i++) {
            if (ints[i] <= 0) {
                ints[i] = length + 1;
            }
        }
        for (int i = 0; i < length; i++) {
            int index = Math.abs(ints[i]) - 1;
            if (index < length) {
                ints[index] = -Math.abs(ints[index]);
            }
        }
        for (int i = 0; i < length; i++) {
            if (ints[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }
}
