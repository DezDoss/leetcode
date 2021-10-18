package leetcode.com;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK_560 {

    public static void main(String[] args) {
        System.out.println(subarraySum2(new int[] {1,1,1,1,1,1}, 3));
    }

    //with negative elements
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0, sum = 0;
        map.put(0, 1);
        for(int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    //without negative elements
    public static int subarraySum2(int[] nums, int k) {
        int begin = 0, sum = 0, count = 0;
        for (int num : nums) {
            sum += num;
            while(sum > k) {
              sum -= nums[begin++];
            }

            if(sum == k) count++;
        }

        return count;
    }
}
