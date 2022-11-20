package leetcode;

public class Solution394 {
    public String decodeString(String s) {
        StringBuffer result = new StringBuffer(s);
        int indexLeft = result.lastIndexOf("[");
        while (indexLeft!=-1){
            StringBuffer strMiddle = new StringBuffer();
            StringBuffer subStr = new StringBuffer();
            StringBuffer subInt = new StringBuffer();
            int markLeft = 0, makrRight = 0;
            for (int i = indexLeft+1; i < result.length(); i++) {
                if(result.charAt(i)!=']'){
                    subStr.append(result.charAt(i));
                }else {
                    makrRight = i+1;
                    break;
                }
            }
            int count = 0;
            for (int i = indexLeft-1; i >= 0 ; i--) {
                if(result.charAt(i)<='9'&&result.charAt(i)>='0'){
                    subInt.append(result.charAt(i));
                }else {
                    markLeft = i+1;
                    break;
                }
            }
            String subIntReverse = subInt.reverse().toString();
            for (int i = 1; i <= Integer.valueOf(subIntReverse); i++) {
                strMiddle.append(subStr);
            }
            String strLeft = result.substring(0,markLeft);
            String strRight = result.substring(makrRight,result.length());
            result = new StringBuffer(strLeft + strMiddle + strRight);

            indexLeft = result.lastIndexOf("[");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution394 s = new Solution394();
        System.out.println(s.decodeString("100[leetcode]"));
    }
}
