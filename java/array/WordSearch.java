package array;

public class WordSearch {
    public static void main(String[] args) {
        System.out.println();
    }

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (valid(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean valid(char[][] board, int row, int col, String word, int index) {
        if (index >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] == word.charAt(index++)) {
            char c = board[row][col];
            board[row][col] = '#';
            boolean res = valid(board, row - 1, col, word, index) ||
                    valid(board, row + 1, col, word, index) ||
                    valid(board, row, col - 1, word, index) ||
                    valid(board, row, col + 1, word, index);
            board[row][col] = c;
            return res;
        }
        return false;
    }
}
