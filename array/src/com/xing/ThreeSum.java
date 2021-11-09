/*
 * Copyright (c) 2020, guoxing, Co,. Ltd. All Rights Reserved
 */
package com.xing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ThreeSum
 * <a href="https://leetcode-cn.com/problems/3sum/submissions/"/>
 *
 * @author guoxing
 * @date 2021/11/9 7:23 PM
 * @since
 */
public class ThreeSum {

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        int[] r = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum.threeSum(r);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        // 排序，保证数组数据的有序
        sort(nums);
        // 查找符合条件的不重复的且和为0的数组
        return search(nums);
    }

    /**
     * 采用双指针
     * <p>选定一个节点作为固定指针,移动双指针查找符合条件的结果;双指针的限制为,左指针位置小于右指针;
     * 双指针的移动,当结果小于0时,左指针右移,原因在于数组按照从小到大的顺序已排序;
     * 当结果大于0时,右指针左移</p>
     * <p>去重:不管左指针还是右指针或者是固定指针,每次移动时都要判断移动后的数据和移动前的数据是否相等,如果相同则跳过</p>
     */
    public List<List<Integer>> search(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                break;
            }
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int tempR = nums[i] + nums[l] + nums[r];
                if (tempR < 0) {
                    while (l < r && nums[l] == nums[l + 1]) l++;// 去重
                    l++;
                } else if (tempR > 0) {
                    while (l < r && nums[r] == nums[r - 1]) r--; // 去重
                    r--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[r] == nums[r - 1]) r--; // 去重
                    while (l < r && nums[l] == nums[l + 1]) l++;// 去重
                    r--;
                    l++;
                }
            }


        }
        return result;
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
