package array;

import java.util.Arrays;

public class SearchForARange {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[] {5,7,7,8,8,10}, 6)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int mid = findTarget(nums, target);
        if (mid == -1) {
            return new int[] {-1, -1};
        }
        int lb = mid;
        int rb = mid;
        while (lb - 1 >= 0 && nums[lb - 1] == target) {
            lb -= 1;
        }
        while (rb + 1 <= nums.length - 1 && nums[rb + 1] == target) {
            rb += 1;
        }
        return new int[] {lb, rb};
    }

    private static int findTarget(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                low = mid + 1;
            }
            if (nums[mid] > target) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
