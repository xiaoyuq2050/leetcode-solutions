package array;

public class SubarrayProductLessThanK {
    /*
    [10, 5, 2, 6], k = 100
    output: 8 [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6]
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int rp;
        int product;
        int res = 0;
        for (int lp = 0; lp < nums.length; lp++) {
            rp = lp;
            product = 1;
            while (rp < nums.length && product * nums[rp] < k) {
                res += 1;
                product *= nums[rp];
                rp += 1;
            }
        }
        return res;
    }
}
