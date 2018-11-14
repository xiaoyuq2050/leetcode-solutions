package array;

public class NumOfIslands {
    public int numIslands(char[][] grid) {
        int res = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return res;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    res += 1;
                    bfs(grid, visited, i ,j);
                }
            }
        }
        return res;
    }

    public void bfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1'
                && !visited[i][j]) {
            visited[i][j] = true;
            bfs(grid, visited, i - 1, j);
            bfs(grid, visited, i + 1, j);
            bfs(grid, visited, i, j - 1);
            bfs(grid, visited, i, j + 1);
        }
    }
}
