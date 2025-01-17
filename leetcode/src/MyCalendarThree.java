import java.util.HashMap;
import java.util.Map;

public class MyCalendarThree {
    private Map<Integer, Integer> tree;
    private Map<Integer, Integer> lazy;

    public MyCalendarThree() {
        tree = new HashMap<Integer, Integer>();
        lazy = new HashMap<Integer, Integer>();
    }

    public int book(int startTime, int endTime) {
        update(startTime, endTime-1, 0, 1000000000,1);
        return tree.getOrDefault(1,0);
    }

    public void update(int start, int end, int l, int r, int idx){
        if(r < start || end < l){
            return;
        }
        if(start <= l && r <= end){
            tree.put(idx, tree.getOrDefault(idx,0) + 1);
            lazy.put(idx, lazy.getOrDefault(idx,0) + 1);
        }else {
            int mid = (l+r)>>1;
            update(start,end,l, mid, 2*idx);
            update(start,end,mid+1, r, 2*idx+1);
            tree.put(idx, lazy.getOrDefault(idx,0) + Math.max(tree.getOrDefault(2*idx,0), tree.getOrDefault(2*idx+1,0)));
        }
    }
}
