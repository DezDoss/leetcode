package leetcode.contest.weekly_312;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* You are given a 0-indexed integer array nums of size n and a positive integer k.

We call an index i in the range k <= i < n - k good if the following conditions are satisfied:

The k elements that are just before the index i are in non-increasing order.
The k elements that are just after the index i are in non-decreasing order.
Return an array of all good indices sorted in increasing order.
*
*
*
* TOPICS : prefixSum, array
* */
public class FindAllGoodIndices_2420 {
  public static void main(String[] args) {
    System.out.println(goodIndices(new int[] {2,1,1,1,3,4,1}, 2));
  }

  public static List<Integer> goodIndices(int[] nums, int k) {
    int n = nums.length;
    int[] left = new int[n + 1];
    int[] right = new int[n + 1];
    List<Integer> result = new ArrayList<>();

    Arrays.fill(left, 1);
    Arrays.fill(right, 1);

    for(int i = 1; i < n; i++) {
      left[i] = nums[i] <= nums[i - 1] ? left[i - 1] + 1 : 1;
    }

    for(int i = n - 2; i >= 0; i--) {
      right[i] = nums[i] <= nums[i + 1] ? right[i + 1] + 1 : 1;
    }

    for(int i = k; i < n - k; i++) {
      if(left[i - 1] >= k && right[i + 1] >= k) {
        result.add(i);
      }
    }

    return result;
  }
}
