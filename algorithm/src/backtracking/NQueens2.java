package backtracking;
/*
n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 */
public class NQueens2 {
    int count=0;
    public int totalNQueens(int n) {
        int[] x=new int[n];
        queens(x,n,0);
        return count;
    }
    void queens(int[] x,int n,int row){
        for(int i=0;i<n;i++){
            if(check(x,n,row,i)){
                x[row]=i;
                if(row==n-1){
                    count++;
                    x[row]=0;
                    return;
                }
                queens(x,n,row+1);
                x[row]=0;
            }
        }
    }
    boolean check(int[] x,int n,int row,int col){
        for(int i=0;i<row;i++){
            if(x[i]==col||x[i]+i==col+row||x[i]-i==col-row)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens2 n=new NQueens2();
        int count = n.totalNQueens(4);
        System.out.println(count);
    }
}
