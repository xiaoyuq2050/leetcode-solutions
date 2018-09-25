package array;

import java.util.Arrays;

public class DecodeWays {
    public static void main(String[] args) {
        System.out.println(numDecodings3("12"));
    }

    // Solution 1: space complexity: O(n)
    public static int numDecodings1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            if (first >= 1 && first <= 9) {
                dp[i + 1] = dp[i];
            }
            if (second >= 10 && second <= 26) {
                dp[i + 1] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }

    // Solution 2: space complexity: O(1)
    public static int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int dp_1 = 1;
        int dp_2 = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < s.length(); i++) {
            int first = Integer.parseInt(s.substring(i, i + 1));
            int second = Integer.parseInt(s.substring(i - 1, i + 1));
            int dp_new = 0;
            if (first >= 1 && first <= 9) {
                dp_new = dp_2;
            }
            if (second >= 10 && second <= 26) {
                dp_new += dp_1;
            }
            dp_1 = dp_2;
            dp_2 = dp_new;
        }
        return dp_2;
    }

    // faster because no use of substring
    public static int numDecodings3(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            if (i - 2 >= 0 && ((s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') || s.charAt(i - 2) == '1')) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}
