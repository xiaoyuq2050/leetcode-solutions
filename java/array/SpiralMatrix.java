package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] test = new int [3][4];
        test[0][0] =1;
        test[0][1] =2;
        test[0][2] =3;
        test[0][3] =4;
        test[1][0] =5;
        test[1][1] =6;
        test[1][2] =7;
        test[1][3] =8;
        test[2][0] =9;
        test[2][1] =10;
        test[2][2] =11;
        test[2][3] =12;
        System.out.println(spiralOrder(test));
    }
    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        boolean isRight = true;
        boolean isDown = true;
        int rowMin = 0;
        int rowMax = matrix.length - 1;
        int colMin = 0;
        int colMax = matrix[0].length - 1;
        int row = 0;
        int col = 0;
        List<Integer> res = new ArrayList<>();
        while (true) {
            if (isRight) {
                row = rowMin;
                col = colMin;
            }
            while (isRight) {
                res.add(matrix[row][col++]);
                if (col > colMax) {
                    rowMin++;
                    isRight = false;
                }
            }
            if (rowMin > rowMax) {
                break;
            }
            if (isDown) {
                row = rowMin;
                col = colMax;
            }
            while (isDown) {
                res.add(matrix[row++][col]);
                if (row > rowMax) {
                    colMax--;
                    isDown = false;
                }
            }
            if (colMin > colMax) {
                break;
            }
            if (!isRight) {
                row = rowMax;
                col = colMax;
            }
            while (!isRight) {
                res.add(matrix[row][col--]);
                if (col < colMin) {
                    rowMax--;
                    isRight = true;
                }
            }
            if (rowMin > rowMax) {
                break;
            }
            if (!isDown) {
                row = rowMax;
                col = colMin;
            }
            while (!isDown) {
                res.add(matrix[row--][col]);
                if (row < rowMin) {
                    colMin++;
                    isDown = true;
                }
            }
            if (colMin > colMax) {
                break;
            }
        }
        return res;
    }
}
