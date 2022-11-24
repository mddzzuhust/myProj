

public class Solution1728 {
    public boolean canMouseWin(String[] grid, int catJump, int mouseJump) {
        int[][][] dp = new int[510][65][65];
        for (int i = 0; i < 510; i++) {
            for (int j = 0; j < 65; j++) {
                for (int k = 0; k < 65; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int x1 = -1, x2 = -1;
        int y1 = -1, y2 = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length(); j++) {
                if (grid[i].charAt(j) == 'C') {
                    y1 = i;
                    y2 = j;
                }
                if (grid[i].charAt(j) == 'M') {
                    x1 = i;
                    x2 = j;
                }
            }
        }
        int t = help(grid, dp, 0, fun(x1, x2), fun(y1, y2), catJump, mouseJump);
        if (t == 1) return true;
        return false;
    }

    public int help(String[] grid, int[][][] dp, int t, int x, int y, int catJump, int mouseJump) {
        if (t == 500) return dp[t][x][y] = 0;
        if (dp[t][x][y] != -1) return dp[t][x][y];
        int x1 = x / 8;
        int x2 = x % 8;
        int y1 = y / 8;
        int y2 = y % 8;
        if (t % 2 == 0) {
            if (grid[x1].charAt(x2) == 'F') return dp[t][x][y] = 1;
        }
        if (t % 2 == 1) {
            if (grid[y1].charAt(y2) == 'F') return dp[t][x][y] = 2;
        }
        if (x1 == y1 && x2 == y2) return dp[t][x][y] = 2;
        if (t % 2 == 0) {
            boolean cat_win = true;
            for (int i = 0; i <= mouseJump; i++) {
                int x1_new = x1 + i;
                if (x1_new >= 0 && x1_new < grid.length) {
                    if (grid[x1_new].charAt(x2) == '#') break;
                    int next = help(grid, dp, t + 1, fun(x1_new, x2), y, catJump, mouseJump);
                    if (next == 1) return dp[t][x][y] = 1;
                    else if (next != 2) cat_win = false;
                }
            }
            for (int i = 0; i <= mouseJump; i++) {
                int x1_new = x1 - i;
                if (x1_new >= 0 && x1_new < grid.length) {
                    if (grid[x1_new].charAt(x2) == '#') break;
                    int next = help(grid, dp, t + 1, fun(x1_new, x2), y, catJump, mouseJump);
                    if (next == 1) return dp[t][x][y] = 1;
                    else if (next != 2) cat_win = false;
                }
            }
            for (int i = 0; i <= mouseJump; i++) {
                int x2_new = x2 + i;
                if (x2_new >= 0 && x2_new < grid[0].length()) {
                    if (grid[x1].charAt(x2_new) == '#') break;
                    int next = help(grid, dp, t + 1, fun(x1, x2_new), y, catJump, mouseJump);
                    if (next == 1) return dp[t][x][y] = 1;
                    else if (next != 2) cat_win = false;
                }
            }
            for (int i = 0; i <= mouseJump; i++) {
                int x2_new = x2 - i;
                if (x2_new >= 0 && x2_new < grid[0].length()) {
                    if (grid[x1].charAt(x2_new) == '#') break;
                    int next = help(grid, dp, t + 1, fun(x1, x2_new), y, catJump, mouseJump);
                    if (next == 1) return dp[t][x][y] = 1;
                    else if (next != 2) cat_win = false;
                }
            }
            if (cat_win) return dp[t][x][y] = 2;
            else return dp[t][x][y] = 0;
        } else {
            boolean mouse_win = true;
            for (int i = 0; i <= catJump; i++) {
                int y1_new = y1 + i;
                if (y1_new >= 0 && y1_new < grid.length) {
                    if (grid[y1_new].charAt(y2) == '#') break;
                    int next = help(grid, dp, t + 1, x, fun(y1_new, y2), catJump, mouseJump);
                    if (next == 2) return dp[t][x][y] = 2;
                    else if (next != 1) mouse_win = false;
                }
            }
            for (int i = 0; i <= catJump; i++) {
                int y1_new = y1 - i;
                if (y1_new >= 0 && y1_new < grid.length) {
                    if (grid[y1_new].charAt(y2) == '#') break;
                    int next = help(grid, dp, t + 1, x, fun(y1_new, y2), catJump, mouseJump);
                    if (next == 2) return dp[t][x][y] = 2;
                    else if (next != 1) mouse_win = false;
                }
            }
            for (int i = 0; i <= catJump; i++) {
                int y2_new = y2 + i;
                if (y2_new >= 0 && y2_new < grid[0].length()) {
                    if (grid[y1].charAt(y2_new) == '#') break;
                    int next = help(grid, dp, t + 1, x, fun(y1, y2_new), catJump, mouseJump);
                    if (next == 2) return dp[t][x][y] = 2;
                    else if (next != 1) mouse_win = false;
                }
            }
            for (int i = 0; i <= catJump; i++) {
                int y2_new = y2 - i;
                if (y2_new >= 0 && y2_new < grid[0].length()) {
                    if (grid[y1].charAt(y2_new) == '#') break;
                    int next = help(grid, dp, t + 1, x, fun(y1, y2_new), catJump, mouseJump);
                    if (next == 2) return dp[t][x][y] = 2;
                    else if (next != 1) mouse_win = false;
                }
            }
            if(mouse_win) return dp[t][x][y]=1;
            else return dp[t][x][y]=0;
        }
    }

    public int fun(int a, int b) {
        return a * 8 + b;
    }
}
