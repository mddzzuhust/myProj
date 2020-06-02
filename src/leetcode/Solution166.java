import java.util.HashMap;
import java.util.Map;

public class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        long num=numerator;
        long den=denominator;
        boolean neg=num*den<0;

        num=Math.abs(num);
        den=Math.abs(den);

        String res=neg?"-"+Long.toString(num/den):Long.toString(num/den);
        long remainder=num%den;
        return (remainder==0)?res:(res+"."+getDec(remainder,den));
    }
    private StringBuilder getDec(long remainder,long den){
        Map<Long,Integer> map=new HashMap<Long,Integer>();
        int i=0;
        StringBuilder sb=new StringBuilder();
        while(remainder!=0&&!map.containsKey(remainder)){
            map.put(remainder,i);
            i++;
            remainder*=10;
            sb.append(Long.toString(remainder/den));
            remainder%=den;
        }
        if(remainder!=0){
            sb.insert((int)map.get(remainder),'(');
            sb.append(')');
        }
        return sb;
    }
    public static void main(String[] args){
        Solution166 s=new Solution166();
        System.out.println(s.fractionToDecimal(1,3));;
    }
}