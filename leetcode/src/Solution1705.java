

import java.util.PriorityQueue;

public class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] < o2[1] ? -1 : 1);
        int eatNum = 0;
        for (int i = 0; i < apples.length || queue.size() > 0; i++) {
            while (!queue.isEmpty()) {
                int[] apple = queue.peek();
                if (apple[1] <= i) {
                    queue.poll();
                } else {
                    break;
                }
            }
            if (i < apples.length && apples[i] > 0) {
                queue.add(new int[]{apples[i], days[i] + i});
            }
            int[] ap = queue.peek();
            if (ap != null && ap[0] > 0) {
                eatNum++;
                ap[0] -= 1;
                if(ap[0]==0){
                    queue.poll();
                }
            }
        }
        return eatNum;
    }

    public static void main(String[] args) {
        Solution1705 s = new Solution1705();
        int[] apples = new int[]{3,0,0,0,0,2};
        int[] days = new int[]{3,0,0,0,0,2};
        System.out.println(s.eatenApples(apples,days));
    }
}
