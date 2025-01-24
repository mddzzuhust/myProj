package byteDance;

public class Solution62 {
    public int uniquePaths(int m, int n) {
        int[][] res =new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    res[i][j]=1;
                }else{
                    res[i][j]=0;
                }
            }
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                res[i][j]=res[i-1][j]+res[i][j-1];
            }
        }
        return res[m-1][n-1];
    }
    public static void main(String[] args){
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths(2,2));
    }
}
