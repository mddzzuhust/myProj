package dynamic;
/**
 * LCS是Longest Common Subsequence的缩写，即最长公共子序列。
 * 一个序列，如果是两个或多个已知序列的子序列，且是所有子序列中最长的，则为最长公共子序列。
 */
public class LCS {
    public static void main(String[] args){
        String a="saabcd";
        String b="aaeefdhe";
        int[][] dp=new int[a.length()+1][b.length()+1];

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                dp[i][j]=0;
            }
        }

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                if(a.charAt(i-1)==b.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[a.length()][b.length()]);
    }
}