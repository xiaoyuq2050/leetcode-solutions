package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[] {0,1,0,0,9}));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        backtrack(res, nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, int[] nums, int start) {
        if (start == nums.length - 1) {
            List<Integer> listToAdd = new ArrayList<>();
            for (int elem: nums) {
                listToAdd.add(elem);
            }
            res.add(listToAdd);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[i] == nums[i - 1]) {
                continue;
            }

            swap(nums, i, start);
            backtrack(res, nums, start + 1);
            swap(nums, i, start);
        }
    }

    private static void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}

//[[0,0,0,1,9],[0,0,0,9,1],[0,0,1,0,9],[0,0,1,9,0],[0,0,9,0,1],[0,0,9,1,0],[0,1,0,0,9],[0,1,0,9,0],[0,1,9,0,0],[0,9,0,0,1]
// ,[0,9,0,1,0],[0,9,1,0,0],[1,0,0,0,9],[1,0,0,9,0],[1,0,9,0,0],[1,9,0,0,0],[9,0,0,0,1],[9,0,0,1,0],[9,0,1,0,0],[9,1,0,0,0]]