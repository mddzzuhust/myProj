

public class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dir = new int[4][2];
        dir[0][0]=-1;dir[0][1]=0;
        dir[1][0]=0;dir[1][1]=1;
        dir[2][0]=1;dir[2][1]=0;
        dir[3][0]=0;dir[3][1]=-1;

        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1){
                    int count = dfs(grid,i,j,dir,0);
                    if(count>max){
                        max = count;
                    }
                }
            }
        }
        return max;
    }

    private int dfs(int[][] grid,int i, int j, int[][] dir,int count){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length){
            return 0;
        }
        if(grid[i][j]==0){
            return 0;
        }
        grid[i][j]=0;
        count++;
        for (int k = 0; k < dir.length; k++) {
            int num = dfs(grid,i+dir[k][0],j+dir[k][1],dir,0);
            count = count + num;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution695 s = new Solution695();
        int[][] grid = new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                                   {0,0,0,0,0,0,0,1,1,1,0,0,0}};
        System.out.println(s.maxAreaOfIsland(grid));
    }
}
