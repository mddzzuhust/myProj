package greedy;
import java.util.Arrays;
//题目一：最优装载问题
//一条小船用来运输古董到河对岸。假设船的最大载重量为MAXWEIGHT，每件古董的重量为w_i，怎么能够装载最多数量的古董到船上呢？
//
//样例数据：
//
//MAXWEIGHT 为 30
//
//给定8个古董，重量分别为：[4, 10, 7, 11, 3, 5, 14, 2]
//
//算法分析
//
//这个问题是一个典型的可以使用贪心算法解决的问题。
//
//通过分析题目可以看到，小船的载重量（MAXWEIGHT）是固定的，要求装载的物品数量最多，那么应该优先选择把重量最小的物品装上船，然后不断装载剩余的物品，直到达到小船载重量的要求。
//
//选择先装载重量最小的物品，这个选择策略就采用了贪心（Greedy）策略，从局部最优达到全局最优，从而产生最优装载问题的最优解。
//
//算法设计与实现
public class OptimizedLoading {

    public static int MAXWEIGHT = 30;// 小船的载重量
    public static int AMOUNT = 8;// 古董个数

    /*
     * 装载算法（贪心算法）
     * */
    public static int maxLoading(int[] weight) {
        //计数器，用于记录装载到小船上古董的数量
        int counter = 0;
        // 对weight数组进行排序
        Arrays.sort(weight);
        int temp = 0; // 记录装载到船上的古董重量
        for (int i = 0; i < AMOUNT; i++) {
            temp += weight[i]; // 贪心策略：每次装入最轻者
            if (temp <= MAXWEIGHT) // 若加入最轻者后还小于载重量，则古董个数+1
                counter++;
            else
                //超重，不能装载
                break;
        }
        //返回装载的古董的数量
        return counter;

    }

    public static void main(String[] args) {

        int ANSWER = 0; // 记录已装载的古董个数
        int[] weight = { 4, 10, 7, 11, 3, 5, 14, 2 };
        ANSWER = maxLoading(weight);
        System.out.println("能装入的古董最大数量为: " + ANSWER);
    }

}