package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        System.out.println(permute(new int[] {1,2,3}));
    }

    // Solution1 :
    // time complexity: O(n! * n)
    // The number of recursive calls, T(n) satisfies the recurrence T(n) = T(n - 1) + T(n - 2) + ... + T(1) + T(0),
    // which solves to T(n) = O(2^n). Since we spend O(n) time within a call, the time complexity is O(n2^n);

//    public static List<List<Integer>> permute(int[] nums) {
//        List<List<Integer>> res = new ArrayList<>();
//        if (nums == null || nums.length == 0) {
//            return res;
//        }
//        backtrack(res, new ArrayList<>(), nums);
//        return res;
//    }
//
//    private static void backtrack(List<List<Integer>> res, List<Integer> list, int[] nums) {
//        if (list.size() == nums.length) {
//            res.add(new ArrayList<>(list));
//            return;
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (list.contains(nums[i])) {
//                continue; // O(n)
//            }
//            list.add(nums[i]);
//            backtrack(res, list, nums);
//            list.remove(list.size() - 1);
//        }
//    }

    // Solution 2:
    // time complexity: O(n!)
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
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
