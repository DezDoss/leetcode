package leetcode.october;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllDuplicatesInAnArray_442_5_day {

    public static void main(String[] args) {
        System.out.println(findDuplicates(new int[] {4,3,2,7,8,2,3,1}));
    }

    //mutating array
    private static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int num : nums) {
            int n = Math.abs(num) - 1;
            if(nums[n] < 0) {
                result.add(n + 1);
            } else {
                nums[n] *= -1;
            }
            System.out.println(Arrays.toString(nums));
        }

        return result;
    }

    //without mutating input array
    private static List<Integer> findDuplicates2(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                System.out.println(Arrays.toString(nums));
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(nums[i]);
            }
        }
        return result;
    }
}
