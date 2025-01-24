package byteDance;

import java.util.ArrayList;
import java.util.List;

public class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> ret=new ArrayList<String>(),inner,outter;
        if(n==0){
            ret.add("");
            return ret;
        }
        if(n==1){
            ret.add("()");
            return ret;
        }
        for(int i=0;i<n;i++){
            inner=generateParenthesis(i);
            outter=generateParenthesis(n-1-i);
            for(int j=0;j<inner.size();j++){
                for(int k=0;k<outter.size();k++){
                    ret.add("("+inner.get(j)+")"+outter.get(k));
                }
            }
        }
        return ret;
    }
    public static void main(String[] args){
        Solution22 s = new Solution22();
        int[] input = {1, 2, 3, 4};
        System.out.println(s.generateParenthesis(3));
    }
}
