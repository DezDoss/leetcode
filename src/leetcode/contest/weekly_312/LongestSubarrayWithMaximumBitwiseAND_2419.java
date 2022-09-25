package leetcode.contest.weekly_312;

import java.util.Arrays;

public class LongestSubarrayWithMaximumBitwiseAND_2419 {
  public static void main(String[] args) {
    System.out.println(longestSubarray(new int[] {1,2,3,3,2,2}));
    System.out.println(longestSubarray(new int[] {1,2,3,4}));
  }

  public static int longestSubarray(int[] nums) {
    int max = Arrays.stream(nums).max().getAsInt();
    int longest = 0;
    int currLongest = 0;

    for(int num : nums) {
      if(num == max) {
        currLongest++;
      } else {
        currLongest = 0;
      }
      longest = Math.max(longest, currLongest);
    }
    return longest;
  }
}
