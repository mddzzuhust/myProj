package byteDance;

public class Solution8 {
    public int myAtoi(String str) {
        int i=0,sign=1;
        boolean overflow=false;
        int len=str.length();
        //System.out.println(len);
        while(i<len)
        {
            if(str.charAt(i)==' '||str.charAt(i)=='\n'||str.charAt(i)=='\t')
                i++;
            else break;
        }
        if(i==len) return 0;

        if(str.charAt(i)=='-')
        {sign=-1;i++;}
        else if(str.charAt(i)=='+')
        {i++;}
        int ret=0;
        while(i<len)
        {
            if (str.charAt(i) < '0' || str.charAt(i) > '9')
                break;
            if((sign==1)&&(ret>(Integer.MAX_VALUE-(str.charAt(i)-'0'))/10))
            {
                overflow=true;
                break;
            }
            if((sign==-1)&&(-ret<(Integer.MIN_VALUE+(str.charAt(i)-'0'))/10))
            {
                overflow=true;
                break;
            }
            ret=ret*10+(str.charAt(i)-'0');
            i++;
        }
        //System.out.println(len);
        if(overflow)
        {
            if(sign==1)
            {
                return Integer.MAX_VALUE;
            }
            else
                return Integer.MIN_VALUE;
        }
        return ret*sign;
    }
    public static void main(String[] args)
    {
        Solution8 s=new Solution8();
        System.out.println(s.myAtoi("     1234567897889"));
    }
}
