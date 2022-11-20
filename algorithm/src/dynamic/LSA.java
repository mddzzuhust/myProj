package dynamic;

public class LSA {
    public int MaxSubStringSum(int[] num,int n){
        int MaxSum = num[0];
        int TempMaxSum = num[0];
        for (int i = 1; i < n; i++) {
            TempMaxSum = Math.max(num[i],TempMaxSum+num[i]);
            MaxSum = Math.max(MaxSum,TempMaxSum);
        }
        return MaxSum;
    }

    public static void main(String[] args) {
        LSA lsa = new LSA();
        int[] num = {1,2,3,-7,5};
        System.out.println(lsa.MaxSubStringSum(num,5));
    }
}