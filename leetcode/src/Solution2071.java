import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution2071 {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int min = 0;
        int max = Math.min(tasks.length, workers.length);
        while (min < max){
            int mid = (min + max + 1) >> 1;
            if(check(mid, tasks,workers,pills,strength)){
                min = mid;
            }else {
                max = mid -1;
            }
        }
        return min;
    }

    public boolean check(int mid, int[] tasks, int[] workers, int pills, int strength){
        Deque<Integer> queue = new ArrayDeque<>();
        int index = workers.length - 1;
        for (int i = mid - 1; i >= 0; i--) {
            int task = tasks[i];
            while (index >= 0 && workers[index] + strength >= task){
                queue.addLast(workers[index]);
                index--;
            }
            if(queue.size() == 0){
                return false;
            }
            if(queue.getFirst() >= task){
                queue.removeFirst();
            }else if (pills > 0){
                pills--;
                queue.removeLast();
            }else {
                return false;
            }
        }
        return true;
    }
}
