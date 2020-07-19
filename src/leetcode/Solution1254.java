package leetcode;

public class Solution1254 {
    public int closedIsland(int[][] grid) {
        int[][] dir = new int[4][2];
        dir[0][0]=-1;dir[0][1]=0;
        dir[1][0]=0;dir[1][1]=1;
        dir[2][0]=1;dir[2][1]=0;
        dir[3][0]=0;dir[3][1]=-1;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==0){
                    if(DFS(grid,dir,i,j)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
    boolean DFS(int[][] grid, int[][] dir,int row,int column){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length)
            return false;
        if(grid[row][column]==1)
            return true;
        grid[row][column]=1;
        boolean ret = true;
        for (int i = 0; i < dir.length; i++) {
            if(!DFS(grid,dir,row+dir[i][0],column+dir[i][1]))
                ret = false;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution1254 s = new Solution1254();
        int[][] grid = new int[][]{{1,1,1,1,1,1,1},{1,0,0,0,0,0,1},{1,0,1,1,1,0,1},{1,0,1,0,1,0,1},{1,0,1,1,1,0,1},
                                   {1,0,0,0,0,0,1},{1,1,1,1,1,1,1}};
        System.out.println(s.closedIsland(grid));
    }
}
