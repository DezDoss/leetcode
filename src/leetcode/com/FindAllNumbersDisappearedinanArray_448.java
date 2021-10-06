package leetcode.com;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedinanArray_448 {

    public static void main(String[] args) {
        System.out.println(findMissing(new int[] {4,3,2,7,8,2,3,1}));
    }

    private static List<Integer> findMissing(int[] nums) {
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            while(nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                result.add(i + 1);
            }
        }

        return result;
    }
}
