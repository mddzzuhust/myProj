package leetcode;

public class Solution1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int[][] gx = new int[grid.length+1][grid[0].length+1];
        int[][] gy = new int[grid.length+1][grid[0].length+1];

        for (int i = 1; i <= grid.length; i++) {
            for (int j = 1; j <= grid[0].length; j++) {
                gx[i][j] = gx[i][j-1] + grid[i-1][j-1];
                gy[i][j] = gy[i-1][j] + grid[i-1][j-1];
            }
        }

        int max = 0;
        for (int i = 1; i < gx.length; i++) {
            for (int j = 1; j < gx[0].length; j++) {
                for (int k = gx[0].length-1; k >= j; k--) {
                    int l = k-j+1;
                    if(l<=max){
                        break;
                    }
                    if(i+k-j>=gx.length||i+k-j>=gy.length){
                        continue;
                    }
                    if(gx[i][k]-gx[i][j-1]!=l){
                        continue;
                    }
                    if(gx[i+k-j][k]-gx[i+k-j][j-1]!=l){
                        continue;
                    }
                    if(gy[i+k-j][j]-gy[i-1][j]!=l){
                        continue;
                    }
                    if(gy[i+k-j][k]-gy[i-1][k]!=l){
                        continue;
                    }

                    max = l;
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        Solution1139 s = new Solution1139();
        int[][] grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(s.largest1BorderedSquare(grid));
    }
}

//
