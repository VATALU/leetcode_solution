package org.vatalu.easy;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
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
    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int[] nums2 = {2, 5, 6};
    int[] answer = {1, 2, 2, 3, 5, 6};
    Assert.assertArrayEquals(answer, Solution.mergeSortedArray(nums1, 3, nums2, 3));
  }

  @Test
  public void testFindDuplicate() {
    int nums[] = {1, 2, 3, 4, 1};
    Assert.assertEquals(1, Solution.findDuplicate(nums));
  }

  @Test
  public void testFirstMissingPositive() {
    int nums[] = {1, 2, 0};
    Assert.assertEquals(3, Solution.firstMissingPositive(nums));
  }

  @Test
  public void testMySqrt() {
    int x = 4;
    Assert.assertEquals(2, Solution.mySqrt(x));
  }

  @Test
  public void testNextGreatestLetter() {
    char[] letters = {'c', 'f', 'j'};
    char target = 'z';
    Assert.assertEquals('c', Solution.nextGreatestLetter(letters, target));
  }

  @Test
  public void testSingleNumber() {
    int[] nums = {1, 2, 2};
    Assert.assertEquals(1, Solution.singleNumber(nums));
  }

  @Test
  public void testMissingNumber() {
    int[] nums = {0, 1, 2, 4};
    Assert.assertEquals(3, Solution.missingNumber(nums));
  }

  @Test
  public void testFindContentChildrenfindContentChildren() {
    int[] g = {1, 2, 3};
    int[] s = {1, 1};
    Assert.assertEquals(1, Solution.findContentChildren(g, s));
  }

  @Test
  public void testEraseOverlapIntervals() {
    Interval interval = new Interval(1, 2);
    Interval interval1 = new Interval(2, 3);
    Interval[] intervals = {interval, interval1, interval};
    Assert.assertEquals(1, Solution.eraseOverlapIntervals(intervals));
  }

  @Test
  public void testFindMinArrowShots() {
    int[][] points = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
    Assert.assertEquals(2, Solution.findMinArrowShots(points));
  }

  @Test
  public void testReconstructQueue() {
    int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
    int[][] result = {{5, 0}, {7, 0}, {5, 2}, {6, 1}, {4, 4}, {7, 1}};
    Assert.assertArrayEquals(result, Solution.reconstructQueue(people));
  }

  @Test
  public void testCountSmaller() {
    int[] nums = {5, 2, 6, 1};
    List<Integer> integers = Arrays.asList(2, 1, 1, 0);
//        Assert.assertThat(Solution.countSmaller(nums), CoreMatchers.is(integers));
    Assert.assertEquals(integers, Solution.countSmaller(nums));
  }

  @Test
  public void testCanPlaceFlowers() {
    int[] nums = {1, 0, 0, 0, 1};
    int n = 1;
    Assert.assertEquals(true, Solution.canPlaceFlowers(nums, n));
  }

  @Test
  public void testRob() {
    int[] nums = {1, 4, 3, 1};
    int n = 5;
    Assert.assertEquals(n, Solution.rob(nums));
  }

  @Test
  public void testNumberOfArithmeticSlices() {
    int[] nums = {1, 2, 3, 4};
    Assert.assertEquals(3, Solution.numberOfArithmeticSlices(nums));
  }

  @Test
  public void testIntegerBreak() {
    int n = 10;
    int result = 36;
    Assert.assertEquals(result, Solution.integerBreak(n));
  }

  @Test
  public void testLongestConsecutive() {
    int[] nums = {100, 4, 200, 1, 3, 2};
    int reuslt = 4;
    Assert.assertEquals(reuslt, Solution.longestConsecutive(nums));
  }

  @Test
  public void testTopKFrequent() {
    int[] nums = {1, 1, 1, 2, 2, 3};
    int k = 2;
    Assert.assertArrayEquals(new int[]{2, 1}, Solution.topKFrequent(nums, k));
  }

  @Test
  public void testNumIslands() {
    char[][] grids = {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'}
    };
    Solution.numIslands(grids);
  }
}