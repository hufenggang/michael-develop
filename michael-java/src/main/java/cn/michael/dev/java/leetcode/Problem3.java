package cn.michael.dev.java.leetcode;

import java.util.*;

/**
 * Created by hufenggang on 2020/4/30.
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Problem3 {

    public static void main(String[] args) {
        String str = "aaaabbvv";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int i = 0;
        int maxLength = 0;

        while (end < s.length()) {
            char c = s.charAt(i);
            if (set.contains(c)) {

            }
        }


        return 0;
    }
}
