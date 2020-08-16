package Greedy;

//题目三：剪绳子
//给定一根长度为n的绳子，请把绳子剪成m段，
//每段绳子记为k[0],k[1]……k[m]。请问k[0]*k[1]……*k[m]可能的最大乘积是多少？例如：当绳子长度为8时，我们把它剪成长度分别为2,3,3段，
//此时最大乘积为18.
//
//算法分析
//
//从问题的某一个初始解出发逐步逼近给定的目标，以尽可能快的地求得更好的解。
//当达到某算法中的某一步不能再继续前进时，算法停止，这就是贪婪算法。
//
//在剪绳子中，如果绳子的长度大于5，则每次剪出的长度为3的绳子。
//如果剩下的长度仍然大于5，则接着剪出一段长度为3的绳子，重复这个步骤，直到剩下的长度小于5.时间和空间复杂度都为O(1)。
public class CutForMaxProduct4 {

    // Greedy solution for Max Product Problem
    public static int maxProd(int length) {
        if (length < 2)
            return 0;
        if (length == 2)
            return 1;
        if (length == 3)
            return 2;
        int timesOf3 = length / 3;    //剪长度为3的绳子段
        if ((length - timesOf3 * 3) == 1) // 当长度为4的时候不能去用3剪
            timesOf3 -= 1;
        int timesOf2= (length - timesOf3* 3) / 2;     // 这时应该把绳子剪成长度为2的两段：2*2>1*3
        return ((int)(Math.pow(3, timesOf3))*((int)Math.pow(2, timesOf2)));

    }

    /* Driver program to test above functions */
    public static void main(String[] args) {
        System.out.println("Maximum Product is " + maxProd(10));
    }
}