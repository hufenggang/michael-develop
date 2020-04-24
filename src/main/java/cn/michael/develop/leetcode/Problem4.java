package cn.michael.develop.leetcode;

/**
 * Created by hufenggang on 2020/4/24.
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 */
public class Problem4 {

    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {1, 2, 3};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        int target;
        boolean flag = true;
        int index = 0, index1 = 0, index2 = 0;
        int value = 0;
        int value1 = nums1.length > 0 ? nums1[0] : Integer.MAX_VALUE;
        int value2 = nums2.length > 0 ? nums2[0] : Integer.MAX_VALUE;

        if ((nums1.length + nums2.length) % 2 == 1) { // 奇数
            target = (nums1.length + nums2.length) / 2 + 1;
        } else { // 偶数
            target = (nums1.length + nums2.length) / 2;
            flag = false;
        }

        while (index < target) {
            if (value1 < value2) {
                value = value1;
                index++;

                if (index1 < nums1.length - 1) {
                    index1++;
                    value1 = nums1[index1];
                } else {
                    value1 = Integer.MAX_VALUE;
                }
            } else {
                value = value2;
                index++;

                if (index2 < nums2.length - 1) {
                    index2++;
                    value2 = nums2[index2];
                } else {
                    value2 = Integer.MAX_VALUE;
                }
            }
        }

        if (flag) {
            return value;
        } else {
            int valueNext = 0;

            if (value1 < value2) {
                valueNext = value1;
            } else {
                valueNext = value2;
            }
            return (value + valueNext) * 1.0 / 2;
        }

    }
}
