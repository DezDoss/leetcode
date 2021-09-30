package leetcode.alghorithms.binarysearch;

public class UpperLowerBinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearchUpper(new int[] {2, 5, 8, 16, 21, 27, 35}, 21));
    }


    /*
    target
    nums[left] <= target
    nums[right] > target
     */
    private static int binarySearchLower(int[] nums, int target) {
        int left = -1, right = nums.length;
        while(right - left > 1) {
            int middle = left + (right - left) / 2;
            if(nums[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
        }

        return nums[left];
    }

    /*
    target
    nums[left] < target
    nums[right] >= target
     */
    private static int binarySearchUpper(int[] nums, int target) {
        int left = -1, right = nums.length;

        while(right - left > 1) {
            int middle = left + (right - left) / 2;
            if(nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }

        return nums[right];
    }
}
