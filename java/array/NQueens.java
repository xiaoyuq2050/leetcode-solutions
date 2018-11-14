package array;

import java.util.*;

public class NQueens {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }

    public static List<List<String>> solveNQueens(int n) {
        boolean[] dia_1 = new boolean[2 * n - 1];
        boolean[] dia_2 = new boolean[2 * n - 1];
        boolean[] col = new boolean[n];
        List<List<String>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), new StringBuilder(), n, 0, dia_1, dia_2, col);
        return res;
    }

    public static boolean place(int n, int row, int col, boolean[] dia_1, boolean[] dia_2, boolean[] cols) {
        if (cols[col] || dia_1[row + col] || dia_2[n - 1 + col - row]) {
            return false;
        }
        return true;
    }

    public static void updateBoard(int n, int row, int col, boolean[] dia_1, boolean[] dia_2, boolean[] cols, boolean place) {
        if (place) {
            cols[col] = true;
            dia_1[row + col] = true;
            dia_2[n - 1 + col - row] = true;
        } else {
            cols[col] = false;
            dia_1[row + col] = false;
            dia_2[n - 1 + col - row] = false;
        }
    }


    public static void backtrack(List<List<String>> res, List<String> curBoard, StringBuilder curS, int n, int row, boolean[] dia_1, boolean[] dia_2, boolean[] cols) {
        if (row >= n) {
            res.add(new ArrayList<>(curBoard));
        } else {
            for (int col = 0; col < n; col++) {
                if (place(n, row, col, dia_1, dia_2, cols)) {
                    updateBoard(n, row, col, dia_1, dia_2, cols, true);
                    curS.append("Q");
                    for (int i = col + 1; i < n; i++) {
                        curS.append(".");
                    }
                    curBoard.add(curS.toString());
                    backtrack(res, curBoard, new StringBuilder(), n, row + 1, dia_1, dia_2, cols);
                    curS.delete(col, n);
                    curBoard.remove(curBoard.size() - 1);
                    curS.append(".");
                    updateBoard(n, row, col, dia_1, dia_2, cols, false);
                } else {
                    curS.append(".");
                }
            }
        }
    }
}
