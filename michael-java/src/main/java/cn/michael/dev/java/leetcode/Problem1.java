package cn.michael.dev.java.leetcode;

import java.util.*;

/**
 * Created by hufenggang on 2021/6/27.
 *
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。
 */
public class Problem1 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }

        Arrays.sort(nums);

        int first = 0;
        int second = 0;

        int firstIndex = 0;
        int secondIndex = 0;

        for (int i = 0; i < hashMap.keySet().size(); i++) {
            first = hashMap.get(i);

            for (int j = i + 1; j < hashMap.keySet().size(); j++) {
                second = hashMap.get(j);
                if (first + second > target) {
                    break;
                } else if (first + second == target) {
                    firstIndex = i;
                    secondIndex = j;
                    return new int[] {firstIndex, secondIndex};
                } else {
                    continue;
                }
            }
        }

        return null;
    }
}
