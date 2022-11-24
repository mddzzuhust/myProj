

public class Solution1631 {
    private int m;
    private int n;
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minimumEffortPath(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        int l = 0, r = 1000000;
        while (l < r) {
            int mid = l + r >>> 1;
            if (!dfs(0,0,mid,heights,new boolean[m][n]))
                l = mid+1;
            else
                r = mid;
        }
        return l;
    }

    private boolean dfs(int x, int y, int effort, int[][] heights, boolean[][] visited) {
        if (x == m - 1 && y == n - 1)
            return true;
        visited[x][y] = true;
        for (int[] d : dir) {
            int nx = x + d[0], ny = y + d[1];
            if(0<=nx&&nx<m&&0<=ny&&ny<n&&!visited[nx][ny]){
                if(Math.abs(heights[nx][ny]-heights[x][y])>effort)
                    continue;
                if(dfs(nx,ny,effort,heights,visited))
                    return true;
            }
        }
        return false;
    }
}
