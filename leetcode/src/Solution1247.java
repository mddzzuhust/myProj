

public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        if(s1.length()==0)
            return -1;
        if(s1.length()==1&&(!s1.equals(s2)))
            return -1;
        int countx = 0, county = 0;
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            if(s1.charAt(i)=='x'&&(s1.charAt(i)!=s2.charAt(i))){
                countx++;
            }else if(s1.charAt(i)=='y'&&(s1.charAt(i)!=s2.charAt(i))){
                county++;
            }
        }
        if((countx+county)%2!=0)
            return -1;
        int result = 0;
        result = result + countx/2;
        countx = countx%2;
        result = result + county/2;
        county = county%2;
        if(countx==1&&county==1){
            result = result+2;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1247 s = new Solution1247();
        System.out.println(s.minimumSwap("xxyyxyxyxx","xyyxyxxxyx"));
    }
}
