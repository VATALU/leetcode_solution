package org.vatalu.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestSolution {
    @Test
    public void testTwoSum() {
        int[] numbers = {2, 7, 15, 19};
        int target = 9;
        int[] answer = {1, 2};
        Assert.assertArrayEquals(answer, Solution.twoSum(numbers, target));
    }

    @Test
    public void testFindLongestWord() {
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
        Assert.assertEquals("apple", Solution.findLongestWord(s, d));
    }

    @Test
    public void testFindKthLargest() {
        int[] input = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Assert.assertEquals(5, Solution.findKthLargest(input, k));
    }

    @Test
    public void testMergeSortedArray() {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        int[] answer = {1,2,2,3,5,6};
        Assert.assertArrayEquals(answer,Solution.mergeSortedArray(nums1,3,nums2,3));
    }

    @Test
    public void testFindDuplicate(){
        int nums[] = {1,2,3,4,1};
        Assert.assertEquals(1,Solution.findDuplicate(nums));
    }

    @Test
    public void testFirstMissingPositive(){
        int nums[]={1,2,0};
        Assert.assertEquals(3,Solution.firstMissingPositive(nums));
    }

    @Test
    public void testMySqrt(){
        int x=4;
        Assert.assertEquals(2,Solution.mySqrt(x));
    }
}