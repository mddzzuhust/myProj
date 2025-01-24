package byteDance;

public class Solution76 {
    public String minWindow(String s, String t) {
        int[] dict=new int[256];
        int[] map=new int[256];
        int left=0,count=0;
        for(char c:t.toCharArray()){
            dict[c]++;
        }
        int minLen=Integer.MAX_VALUE;
        String result="";
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(dict[c]==0) continue;
            if(++map[c]<=dict[c]) count++;
            if(count==t.length()){
                char lc=s.charAt(left);
                while(dict[lc]==0||map[lc]>dict[lc]){
                    if(map[lc]>dict[lc]){
                        map[lc]--;
                    }
                    lc=s.charAt(++left);
                }
                int len=i-left+1;
                if(len<minLen){
                    minLen=len;
                    result=s.substring(left,left+len);
                }
            }
        }
        return result;
    }
}
