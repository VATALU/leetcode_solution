package org.vatalu.easy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Solution {

    // 167
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    //524
    public static String findLongestWord(String s, List<String> d) {
        String longestString = "";
        for (String ss : d) {
            int i = 0, j = 0;
            for (; i < s.length() && j < ss.length(); ) {
                if (s.charAt(i) != ss.charAt(j)) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
            if (j == ss.length()) {
                if (ss.length() > longestString.length()) {
                    longestString = ss;
                } else if (ss.length() == longestString.length() && ss.compareTo(longestString) < 0) {
                    longestString = ss;
                }
            }
        }
        return longestString;
    }

    // 215
    public static int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private static int partition(int[] nums, int finalLow, int finalHigh) {
        int p = finalLow, k = finalHigh + 1;
        while (true) {
            while (nums[++p] < nums[finalLow] && p < finalHigh) ;
            while (nums[--k] > nums[finalLow] && k > finalLow) ;
            if (p >= k) {
                break;
            }
            swap(nums, p, k);
        }
        swap(nums, finalLow, k);
        return k;
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}