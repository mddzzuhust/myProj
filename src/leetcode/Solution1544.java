package leetcode;

public class Solution1544 {
    public String makeGood(String s) {
        if(s.length()<2){
            return s;
        }
        String result = s;
        while (result.length()>0){
            String tmp = result;
            boolean flag = false;
            for (int i = 0; i < result.length()-1; i++) {
                if((result.charAt(i)==result.charAt(i+1)+32)||(result.charAt(i)+32==result.charAt(i+1))){
                    flag = true;
                    if(i<result.length()-2) {
                        tmp = tmp.substring(0, i) + tmp.substring(i + 2);
                    }else {
                        tmp = tmp.substring(0,i);
                    }
                    break;
                }
            }
            if(flag == true){
                result = tmp;
            }else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1544 s =new Solution1544();
        System.out.println(s.makeGood("abBAcC"));
        System.out.println();
    }
}
