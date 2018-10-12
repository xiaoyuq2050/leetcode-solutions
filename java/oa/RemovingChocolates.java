package oa;

public class RemovingChocolates {
    public static void main(String[] args) {
        System.out.println(Solution(7));
    }

    public static int Solution(int num) {
        int[] dp = new int[num + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i < num + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[num];
    }
}
