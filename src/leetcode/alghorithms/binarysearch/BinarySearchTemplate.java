package leetcode.alghorithms.binarysearch;

public class BinarySearchTemplate {

    public static void main(String[] args) {
        System.out.println(binarySearch3(new int[] {1,2,3,4,5,6,7,8,9,10}, 8));
    }

    /*
    Initial Condition:left = 0, right = length-1
    Termination:left > right
    Searching Left:right = mid-1
    Searching Right:left = mid+1
    */
    private static int binarySearch1(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return -1;
    }

    private static int binarySearch2(int[] nums, int target) {
        if(nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while(left < right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        return left != nums.length && nums[left] == target ?
                left : -1;
    }

    private static int binarySearch3(int[] nums, int target) {
        if(nums.length == 0 || nums == null) {
            return -1;
        }

        int left = 0, right = nums.length - 1;

        while(left + 1 < right) {
            int middle = left + (right - left) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if(nums[middle] < target) {
                left = middle;
            } else {
                right = middle;
            }
        }

        if(nums[left] == target) {
            return left;
        } else if(nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }

}
