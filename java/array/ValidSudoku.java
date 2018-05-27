package array;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

//    public boolean isValidSudoku(char[][] board) {
//        for (int i = 0; i < 9; i++) {
//            Set<Character> charSet = new HashSet<>();
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != '.') {
//                    if (charSet.contains(board[i][j])) {
//                        return false;
//                    }
//                    charSet.add(board[i][j]);
//                }
//            }
//        }
//        for (int i = 0; i < 9; i++) {
//            Set<Character> charSet = new HashSet<>();
//            for (int j = 0; j < 9; j++) {
//                if (board[j][i] != '.') {
//                    if (charSet.contains(board[j][i])) {
//                        return false;
//                    }
//                    charSet.add(board[j][i]);
//                }
//            }
//        }
//        for (int i = 0; i < 9; i += 3) {
//            for (int j = 0; j < 9; j += 3) {
//                if (!checkBlock(board, i, j)) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }
//
//    private boolean checkBlock(char[][] board, int left, int upper) {
//        Set<Character> charSet = new HashSet<>();
//        for (int i = left; i < left + 3; i++) {
//            for (int j = upper; j < upper + 3; j++) {
//                if (board[i][j] != '.') {
//                    if (charSet.contains(board[i][j])) {
//                        return false;
//                    }
//                    charSet.add(board[i][j]);
//                }
//            }
//        }
//        return true;
//    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> cols = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !cols.add(board[j][i])) {
                    return false;
                }
                int rowIdx = 3 * (i / 3);
                int colIdx = 3 * (i % 3);
                if (board[rowIdx + j / 3][colIdx + j % 3] != '.' && !cube.add(board[rowIdx + j / 3][colIdx + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}
