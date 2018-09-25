package array;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] test = new int[] {2,1,0,2,1,0,1,2,0};
        sortColors(test);
        System.out.println(Arrays.toString(test));
    }

    // two pointers.
    public static void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (index <= right) {
            if (nums[index] == 0) {
                swap(nums, left++, index++);
            }
            else {
                if (nums[index] == 2) {
                    swap(nums, index, right--);
                } else {
                    index++;
                }
            }
        }
    }

    private static void swap(int[] nums, int m, int n) {
        int tmp = nums[m];
        nums[m] = nums[n];
        nums[n] = tmp;
    }
}
