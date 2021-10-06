package leetcode.october;

import java.util.Arrays;

public class InPlaceSort {

    public static void main(String[] args) {
        //5 10 12 13 14  16 20
        int[] res = inPlaceSort(new int[] {15, 2, 6, 18, 3, 11, 7, 1, 9, 17, 8, 4, 19, 13, 14, 10, 5, 12, 20, 16});
        System.out.println(Arrays.toString(res));
    }

    private static int[] inPlaceSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        return nums;
    }
}
