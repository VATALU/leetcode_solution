package org.vatalu.easy;

import java.util.ArrayList;
import java.util.List;

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
            int i=0,j=0;
            for(;i<s.length()&&j<ss.length();) {
                if(s.charAt(i)!=ss.charAt(j)) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
            if(j==ss.length()) {
                if(ss.length()>longestString.length()) {
                    longestString=ss;
                } else if(ss.length()==longestString.length()&&ss.compareTo(longestString)==-1) {
                    longestString=ss;
                }
            }
        }
        return longestString;
    }
}