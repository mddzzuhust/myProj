package leetcode;

public class Solution1616 {
    public boolean checkPalindromeFormation(String a, String b) {
        if(check(a,b)||check(b,a))
            return true;
        return false;
    }

    private boolean check(String a, String b){
        char[] stra = a.toCharArray();
        char[] strb = b.toCharArray();
        int length = a.length();
        int left = 0;
        while (left<=length/2){
            if(stra[left]==strb[length-1-left]){
                left++;
            }else {
                break;
            }
        }
        if(left>=length/2)
            return true;
        if(isPa(a.substring(left,length-left))||isPa(b.substring(left,length-left)))
            return true;
        return false;
    }

    private boolean isPa(String str){
        for (int i = 0; i <= str.length()/2; i++) {
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1616 s = new Solution1616();
        String a = "ulacfd";
        String b = "jizalu";
        System.out.println(s.check(a,b));
    }
}
