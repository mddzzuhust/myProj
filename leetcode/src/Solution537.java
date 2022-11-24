

public class Solution537 {
    public String complexNumberMultiply(String a, String b) {
        int a1,a2,b1,b2;
        int index1 = a.indexOf('i');
        if(index1 == -1){
            a1 = Integer.valueOf(a);
            a2 = 0;
        }else {
            int tmp = a.indexOf("+");
            if(tmp == -1){
                a1 = 0;
                String str = a.substring(0,a.length()-1);
                a2 = Integer.valueOf(str);
            }else {
                if(a.charAt(tmp+1)=='-'){
                    String str = a.substring(tmp+2, a.length()-1);
                    a2 = 0-Integer.valueOf(str);
                    str = a.substring(0,tmp);
                    a1 = Integer.valueOf(str);
                }else {
                    String str = a.substring(tmp+1,a.length()-1);
                    a2 = Integer.valueOf(str);
                    str = a.substring(0,tmp);
                    a1 = Integer.valueOf(str);
                }
            }
        }

        index1 = b.indexOf("i");
        if(index1 == -1){
            b1 = Integer.valueOf(b);
            b2 = 0;
        }else {
            int tmp = b.indexOf("+");
            if(tmp == -1){
                b1 = 0;
                String str = b.substring(0,b.length()-1);
                b2 = Integer.valueOf(str);
            }else {
                if(b.charAt(tmp+1)=='-'){
                    String str = b.substring(tmp+2, b.length()-1);
                    b2 = 0-Integer.valueOf(str);
                    str = b.substring(0,tmp);
                    b1 = Integer.valueOf(str);
                }else {
                    String str = b.substring(tmp+1,b.length()-1);
                    b2 = Integer.valueOf(str);
                    str = b.substring(0,tmp);
                    b1 = Integer.valueOf(str);
                }
            }
        }

        int c1 = a1*b1-a2*b2;
        int c2 = a1*b2+a2*b1;
        String result = String.valueOf(c1)+"+"+String.valueOf(c2)+"i";
        return result;
    }

    public static void main(String[] args) {
        Solution537 s = new Solution537();
        System.out.println(s.complexNumberMultiply("1+-1i","1+-1i"));
    }
}
