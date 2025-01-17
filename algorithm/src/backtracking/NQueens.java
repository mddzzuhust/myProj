package backtracking;

import java.util.ArrayList;
import java.util.List;
/*
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。

n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。

每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<List<String>>();
        if(n<=0) return result;
        int[] columns=new int[n];
        helper(n,result,columns,0);
        return result;
    }
    private void helper(int n,List<List<String>> result,int[] columns,int row){
        if(row==n){
            List<String> list=new ArrayList<String>();
            for(int i=0;i<n;i++){
                StringBuffer sb=new StringBuffer();
                for(int j=0;j<n;j++){
                    if(columns[i]==j){
                        sb.append('Q');
                    }else{
                        sb.append('.');
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(columns,row,i)){
                columns[row]=i;
                helper(n,result,columns,row+1);
            }
        }
    }
    private boolean isValid(int[] columns, int row1, int column1){
        for(int row2 = 0; row2 < row1; row2++){
            if(columns[row2] == column1)
                return false;
            int diff = Math.abs(column1 - columns[row2]);
            if(diff == (row1 - row2)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nq=new NQueens();
        List<List<String>> list = nq.solveNQueens(4);
        for(List<String> list1:list){
            for (String string : list1) {
                System.out.println(string);
            }
            System.out.println();
        }
    }
}
