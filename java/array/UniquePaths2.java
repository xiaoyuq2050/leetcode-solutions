package array;

public class UniquePaths2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        boolean obsBefore = false;
        for (int k = 0; k < obstacleGrid[0].length; k++) {
            if (!obsBefore) {
                if (obstacleGrid[0][k] == 0) {
                    obstacleGrid[0][k] = 1;
                } else {
                    obstacleGrid[0][k] = 0;
                    obsBefore = true;
                }
            } else {
                obstacleGrid[0][k] = 0;
            }
        }
//        System.out.println(Arrays.toString(obstacleGrid[0]));
        obsBefore = false;
        for (int k = 1; k < obstacleGrid.length; k++) {
            if (!obsBefore) {
                if (obstacleGrid[k][0] == 0) {
                    obstacleGrid[k][0] = 1;
                } else {
                    obstacleGrid[k][0] = 0;
                    obsBefore = true;
                }
            } else {
                obstacleGrid[k][0] = 0;
            }
//            System.out.println(obstacleGrid[k][0]);
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}
