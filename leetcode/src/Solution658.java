import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if(Math.abs(a-x) != Math.abs(b-x)){
                    return Math.abs(a-x)-Math.abs(b-x);
                }else {
                    return a-b;
                }
            }
        });

        List<Integer> ans = list.subList(0,k);
        Collections.sort(ans);
        return ans;
    }
}
