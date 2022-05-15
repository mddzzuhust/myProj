package greedy;
//题目二：活动安排
//设有n个活动的集合e={1，2，…，n}，其中每个活动都要求使用同一资源，如演讲会场等，而在同一时间内只有一个活动能使用这一资源。
//每个活动i都有一个要求使用该资源的起始时间s_i和一个结束时间f_i,且s_i< f_i。
//如果选择了活动i，则它在半开时间区间[s_i，f_i]内占用资源。
//若区间[s_i，f_i]与区间[s_j，f_j]不相交，则称活动 i 与活动 j 是相容的。也就是说，当s_i ≥ f_i或s_j ≥ f_j时，活动 i 与活动 j 相容。活动安排问题就是要在所给的活动集合中选出最大的相容活动子集合。
//
//在下面所给出的解活动安排问题的贪心算法gpeedyselector中，
//各活动的起始时间和结束时间存储于数组s和f{中且按结束时间的非减序：．f_1 ≤ f_2 ≤ … ≤ f_n排列。
//如果所给出的活动未按此序排列，我们可以用o(nlogn)的时间将它重排。
import java.util.ArrayList;
import java.util.List;

public class ActivitiesDemo {

    public static List<Integer> arrangeActivity(int[] start, int[] end) {
        int total = start.length;
        int endFlag = end[0];
        List<Integer> results = new ArrayList<>();
        results.add(0);
        for (int i = 0; i < total; i++) {
            if (start[i] > endFlag) {
                results.add(i);
                endFlag = end[i];
            }
        }
        return results;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] start = { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
        int[] end = { 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };
        List<Integer> results = arrangeActivity(start, end);
        for (int i = 0; i < results.size(); i++) {
            int index = results.get(i);
            System.out.println("开始时间:" + start[index] + ",结束时间:" + end[index]);
        }
    }

}
