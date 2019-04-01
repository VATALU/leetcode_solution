package org.vatalu.easy;

import java.util.*;

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

    // 455
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if (g[gi] <= s[si]) {
                gi++;
            }
            si++;
        }
        return gi;
    }

    //435
    public static int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
        int count = 1;
        for (int i = 1, j = 0; i < intervals.length; i++) {
            if (intervals[j].end <= intervals[i].start) {
                count++;
                j = i;
            }
        }
        return intervals.length - count;
    }

    // 452
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int count = 1;
        for (int i = 1, j = 0; i < points.length; i++) {
            if (points[j][1] < points[i][0]) {
                count++;
                j = i;
            }
        }
        return count;
    }

    //406
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> (a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]));
        for (int i = 0; i < people.length; i++) {
            if (people[i][1] < i) {
                int[] temp = people[i];
                int n = people[i][1];
                for (int j = i; j > n; j--) {
                    people[j] = people[j - 1];
                }
                people[n] = temp;
            }
        }
        return people;
    }

    // 315 o(n^2)
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (i != 0 && nums[i] == nums[i - 1]) {
                    count = integers.get(i - 1);
                    break;
                } else if (nums[i] > nums[j]) {
                    count++;
                }
            }
            integers.add(count);
        }
        return integers;
    }

    // 605
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int pre = i == 0 ? 0 : flowerbed[i - 1];
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
                if (pre == 0 && next == 0) {
                    count++;
                    i++;
                } else if(next==1) {
                    i++;
                }
            }
        }
        return count>=n;
    }

    // 392
    public static boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

    //198
    public static int rob(int[] nums) {
        int pre1=0,pre2=0;
        for(int i=0;i<nums.length;i++) {
            int cur = Math.max(pre2+nums[i],pre1);
            pre2=pre1;
            pre1=cur;
        }
        return pre1;
    }

    //213
    public static int rob2(int[] nums) {
       if(Objects.isNull(nums)||nums.length==0){
           return 0;
       }
       if(nums.length==1)
           return nums[0];
       return Math.max(rob(nums,0,nums.length-2),rob(nums,1,nums.length-1));
    }

    private static int rob(int[] nums,int first,int last) {
        int pre1=0,pre2=0;
        for(int i=first;i<=last;i++) {
            int cur = Math.max(pre2+nums[i],pre1);
            pre2=pre1;
            pre1=cur;
        }
        return pre1;
    }

    //413
    public static int numberOfArithmeticSlices(int[] A) {
        if(A==null || A.length==0) {
            return 0;
        }
        int n=A.length;
        int[] dp=new int[n];
        for(int i=2;i<n;i++){
            if(A[i-1]-A[i-2]==A[i]-A[i-1]) {
                dp[i]=dp[i-1]+1;
            }
        }
        int total =0;
        for(int cnt:dp) {
            total+=cnt;
        }
        return total;
    }

    //343
    public static int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    //594
    public static int findLHS(int[] nums) {
        Map<Integer, Integer> countForNum = new HashMap<>();
        for (int num : nums) {
            countForNum.put(num, countForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (int num : countForNum.keySet()) {
            if (countForNum.containsKey(num + 1)) {
                longest = Math.max(longest, countForNum.get(num + 1) + countForNum.get(num));
            }
        }
        return longest;
    }
}