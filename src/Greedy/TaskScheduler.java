package Greedy;
import java.util.Arrays;
//题目五：任务调度问题
//给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，或者在待命状态。
//
//然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
//
//你需要计算完成所有任务所需要的最短时间。
//
//示例 1：
//
//输入: tasks = ["A","A","A","B","B","B"], n = 2
//输出: 8
//执行顺序: A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
//注：
//
//任务的总个数为 [1, 10000]
//n 的取值范围为 [0, 100]
//
//算法分析
//
//算法设计
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        // count char freq, task name doesn't matter, only freq matters
        int[] freq = new int[26];
        for (char c : tasks)
            freq[c - 'A']++;
        // sort first, so we have max freq at freq[25]
        Arrays.sort(freq);
        int time = 0;
        while (freq[25] > 0) { // while we still have task to do, start from most freq task
            // GREEDY
            // each round/row, try to finish n tasks
            for (int i = 0, p = 25; i <= n; i++) { // n is the cooling down factor, p points to the next task to consume
                if (p >= 0 && freq[p] > 0) { // if there is still task to do
                    freq[p]--; // do task
                    p--; // move p to next freq task
                    time++; // take one cycle
                } else if (freq[25] != 0) { // if this is NOT last row, need to fill in idle cycle
                    time++; // take one cycle
                } // else freq[25] == 0 . no more task to do and last row. we WON'T fill in idle
                // cycle
            }
            // sort again so next round we're going to start from most freq task and consume
            // n task if possible
            Arrays.sort(freq);
        }
        return time;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TaskScheduler taskScheduler=new TaskScheduler();

        char[] tasks= {'A','A','A','B','B','B'};
        int n=2;

        int result=-1;

        result=taskScheduler.leastInterval(tasks, n);
        System.out.println("result = "+result);


    }

}