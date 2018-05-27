package array;

public class RotateImage {
    // Solution 1: copy a matrix and relocate each element into matrix
    // space complexity: O(n^2)
//    public void rotate(int[][] matrix) {
//        int[][] originMatrix = new int[matrix.length][matrix.length];
//        for (int i = 0; i < matrix.length; i++) {
//            originMatrix[i] = matrix[i].clone();
//        }
//        for (int i = 0; i < originMatrix.length; i++) {
//            for (int j = 0; j < originMatrix[0].length; j++) {
//                matrix[j][originMatrix.length - 1 - i] = originMatrix[i][j];
//            }
//        }
//    }

    // Solution 2: Flip twice
    // space complexity: O(1)
    public void rotate(int[][] matrix) {
        // 先以主对角线为轴 翻转矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                swapDiagonal(matrix, i, j);
            }
        }

        // 再以中间一列为轴 翻转矩阵
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                swapLeftRight(matrix, i, j);
            }
        }
    }

    private void swapDiagonal(int[][] matrix, int row, int col) {
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[col][row];
        matrix[col][row] = tmp;
    }

    private void swapLeftRight(int[][] matrix, int row, int col) {
        int tmp = matrix[row][col];
        matrix[row][col] = matrix[row][matrix.length - 1 - col];
        matrix[row][matrix.length - 1 - col] = tmp;
    }
}
