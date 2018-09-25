package array;

public class JumpGame {
    public static void main(String[] args) {
        System.out.println(canJump2(new int[] {4,3,1,2,0,1,5}));
    }

    // Solution 1: backtracking，复杂
    public static boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int index = nums.length - 1;
        while (index > 0) {
            for (int i = 0; i < index; i++) {
                if (nums[i] >= index - i) {
                    index = i;
                    break;
                }
                if (i == index - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    // Solution 2: greedy
    public static boolean canJump2(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(nums[i] + i, max);
        }
        return true;
    }
}
