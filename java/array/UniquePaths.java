package array;

import java.util.*;

// dynamic programming
// basic
public class UniquePaths {
    public static void main(String[] args) {

        System.out.println(uniquePaths2(7,3));
    }

    // time complexity: O(m * n)
    // space complexity: O(m * n)
    public static int uniquePaths1(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            res[0][i] = 1;
        }
        for (int j = 0; j < m; j++) {
            res[j][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = res[i - 1][j] + res[i][j - 1];
            }
        }
        return res[m - 1][n - 1];
    }

    // time complexity: O(m * n)
    // space complexity: O(n)
    public static int uniquePaths2(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[n - 1];
    }

}
