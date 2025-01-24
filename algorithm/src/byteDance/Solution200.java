package byteDance;

public class Solution200 {
    public int  numIslands(char[][] grid){
        int count=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    search(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void search(char[][] grid,int x,int y){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length||grid[x][y]!='1')
            return;
        grid[x][y]='0';
        search(grid,x-1,y);
        search(grid,x+1,y);
        search(grid,x,y-1);
        search(grid,x,y+1);
    }
}
