package byteDance;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList<String>();
        if(s==null)  return res;
        int len=s.length();
        if(len<4||len>12) return res;
        String str="";
        mergeString(s,str,res,0);
        return res;
    }
    public void mergeString(String s, String str, List<String> res, int area){
        if(area==3&&isValid(s)){
            res.add(str+s);
        }
        for(int i=1;i<=3&&i<s.length();i++){
            String substr=s.substring(0,i);
            if(isValid(substr)){
                mergeString(s.substring(i),str+substr+".",res,area+1);
            }
        }
    }
    public boolean isValid(String s){
        if(s.charAt(0)=='0') return s.equals("0");
        int num=Integer.parseInt(s);
        return num<=255&&num>0;
    }
}
