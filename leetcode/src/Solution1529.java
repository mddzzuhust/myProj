

public class Solution1529 {
    public int minFlips(String target) {
        int result = 0;
        int index = target.length()-1;
        while (index>=0){
            if(target.charAt(index)=='1'){
                result = 1;
                index--;
            }else {
                break;
            }
        }
        for (int i = index; i > 0; i--) {
            if (target.charAt(i) == '0' && target.charAt(i - 1) == '1') {
                result = result + 2;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1529 s = new Solution1529();
        System.out.println(s.minFlips("001011101"));
    }
}
