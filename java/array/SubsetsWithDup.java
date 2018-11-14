package array;

import java.util.*;

public class SubsetsWithDup {
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(subsetsWithDup(new int[] {4,4,4,1,4}));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // first sort to enable removing duplicates
        Arrays.sort(nums);
        backtrack(res, new ArrayList<>(), nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            // 去重判断条件：i != index
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backtrack(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
