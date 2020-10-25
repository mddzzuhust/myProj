package leetcode;

public class Solution1419 {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int c, r, o, a, k;
        c = 0;
        r = 0;
        o = 0;
        a = 0;
        k = 0;
        char[] chars = croakOfFrogs.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'c') {
                if (k > 0) {
                    k--;
                } else {
                    res++;
                }
                c++;
            }else if(chars[i]=='r'){
                c--;r++;
            }else if(chars[i]=='o'){
                
                r--;o++;
            }else if(chars[i]=='a'){
                o--;a++;
            }else if(chars[i]=='k'){
                a--;k++;
            }
            if(c<0||r<0||o<0||a<0){
                break;
            }
        }
        if(c!=0||r!=0||o!=0||a!=0){
            return -1;
        }
        return res;
    }
}
