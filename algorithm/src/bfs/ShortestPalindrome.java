package bfs;

//最短回文子串
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s.length()<=1) return s;
        StringBuilder s2=new StringBuilder(s);
        s2.reverse();
        String news=s+s2;
        int n=news.length();
        int[] next=new int[n+1];
        buildNext(news,next,n);
        if(next[n]>s.length())
            next[n]=next[n]+1-s.length();
        StringBuilder pres=new StringBuilder(s.substring(next[n]));
        pres.reverse();
        return pres.append(s).toString();
    }
    void buildNext(String s,int[] next,int n){
        int k=-1;
        int j=0;
        next[0]=-1;
        while(j<n){
            if(k==-1||s.charAt(j)==s.charAt(k)){
                k++;j++;next[j]=k;
            }else{
                k=next[k];
            }
        }
    }
    public static void main(String[] args){
        ShortestPalindrome s=new ShortestPalindrome();
        System.out.println(s.shortestPalindrome("BBCABCDABABCDABCDABDE"));
    }
}
