package dfs;

/*
* 题目描述:
* 给你一个由 ‘1’（陆地）和 ‘0’（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。
*
* 示例1：
输入：grid = [
[“1”,“1”,“1”,“1”,“0”],
[“1”,“1”,“0”,“1”,“0”],
[“1”,“1”,“0”,“0”,“0”],
[“0”,“0”,“0”,“0”,“0”]
]
输出：1
*/
public class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null ){
            return 0;
        }
        int num = 0;
        for (int i = 0 ; i < grid.length;i++){
            for (int j = 0;j < grid[0].length;j++){
                //碰到1 再去递归看看周围是不是还有'1'
                if (grid[i][j] == '1'){
                    num++;
                    processInfect(grid,i,j);
                }
            }
        }
        return num;
    }
    /**
     * 判断有多少孤岛
     * @param ints
     * @param i
     * @param j
     * @return
     */
    public static void processInfect(char[][]ints,int i,int j){
        if (i >= ints.length || j >= ints[0].length){
            return ;
        }
        if (i < 0 || j < 0){
            return ;
        }
        if (ints[i][j] == '0'){
            return ;
        }
        //碰到‘1’把他改成'0' 避免重复去计算。
        ints[i][j] = '0';
        //上位置
        processInfect(ints,i - 1,j);
        //下
        processInfect(ints,i + 1,j);
        //左
        processInfect(ints,i,j - 1);
        //右
        processInfect(ints,i,j + 1);
    }
}
