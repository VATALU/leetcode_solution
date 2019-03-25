package org.vatalu.easy;

import java.util.*;
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

    // 88
    public static int[] mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1, index2 = n - 1;
        int indexMerge = m + n - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (index2 < 0) {
                nums1[indexMerge--] = nums1[index1--];
            } else if (nums1[index1] < nums2[index2]) {
                nums1[indexMerge--] = nums2[index2--];
            } else if (nums1[index1] >= nums2[index2]) {
                nums1[indexMerge--] = nums1[index1--];
            }
        }
        return nums1;
    }

    //141
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodes = new HashSet<>();
        while (head != null) {
            if (nodes.contains(head)) {
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    //287
    public static int findDuplicate(int[] nums) {
        Set<Integer> integers = new HashSet<>();
        for (int i : nums) {
            if (integers.contains(i)) {
                return i;
            }
            integers.add(i);
        }
        return -1;
    }

    //41
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int j = 0;
        boolean isFind = false;
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (; j < nums.length; j++) {
                if (nums[j] == i) {
                    j++;
                    isFind = true;
                    break;
                }
            }
            if (isFind == false && j >= nums.length) {
                return i;
            }
            isFind = false;
        }
        return -1;
    }

    // 69
    public static int mySqrt(int x) {
        return new Double(Math.sqrt(x)).intValue();
    }

    //744
    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0, h = letters.length - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (letters[m] <= target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return l < letters.length ? letters[l] : letters[0];
    }

    //136
    public static int singleNumber(int[] nums) {
        int ret = 0;
        for (int n : nums) {
            ret = ret ^ n;
        }
        return ret;
    }

    //268
    public static int missingNumber(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret = ret ^ i ^ nums[i];
        }
        return ret ^ nums.length;
    }

    //260
    public static int[] singleNumber3(int[] nums) {
        int diff = 0;
        for (int num : nums) diff ^= num;
        diff &= -diff;  // 得到最右一位
        int[] ret = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0) ret[0] ^= num;
            else ret[1] ^= num;
        }
        return ret;
    }
}