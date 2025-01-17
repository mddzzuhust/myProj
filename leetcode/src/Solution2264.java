public class Solution2264 {
    public String largestGoodInteger(String num) {
        int res = -1;
        for(int j = 0; j < num.length()-2; j++) {
          int num1 = num.charAt(j)-'0';
          int num2 = num.charAt(j+1)-'0';
          int num3 = num.charAt(j+2)-'0';
          if((num1 == num2) && (num1 == num3) && (num2 == num3)) {
              if(num1 > res){
                  res = num1;
              }
          }
        }
        if(res == -1) {
            return "";
        }
        String string = String.valueOf(res);
        return string + string + string;
    }

    public static void main(String[] args) {
        Solution2264 solution = new Solution2264();
        System.out.println(solution.largestGoodInteger("6777133339"));
    }
}
