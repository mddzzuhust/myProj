package leetcode;

public class Solution5210 {
    public int[] findBall(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] ans = new int[col];
        for (int i = 0; i < col; i++) {
            ans[i] = out(grid, row, col, i, 0);
        }
        return ans;
    }

    private int out(int[][] grid, int row, int col, int x, int y) {
        if (y == row) {
            return x;
        }
        if (x == 0 && grid[y][x] == -1) {
            return -1;
        }
        if (x == col - 1 && grid[y][x] == 1) {
            return -1;
        }
        if (grid[y][x] == 1 && grid[y][x + 1] == -1) {
            return -1;
        }
        if (grid[y][x] == -1 && grid[y][x - 1] == 1) {
            return -1;
        }
        return out(grid, row, col, x + grid[y][x], y + 1);
    }
}
