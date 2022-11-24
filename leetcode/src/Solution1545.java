

public class Solution1545 {
    public char findKthBit(int n, int k) {
        if(k==1)
            return '0';

        int mid = 1<<(n-1);

        if(k==mid){
            return '1';
        }else if(k<mid){
            return findKthBit(n-1,k);
        }else {
            k = 2*mid-k;
            return inverse(findKthBit(n-1,k));
        }
    }
    private char inverse(char bit){
        return (char)('0'+'1'-bit);
    }
}
