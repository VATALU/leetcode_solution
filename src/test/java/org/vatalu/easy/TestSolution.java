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
}