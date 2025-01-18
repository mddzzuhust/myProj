import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {
    List<int[]> booked;
    List<int[]> overlaps;
    public MyCalendarTwo() {
        booked = new ArrayList<int[]>();
        overlaps = new ArrayList<int[]>();
    }

    public boolean book(int startTime, int endTime) {
        for(int[] arr : overlaps) {
            int l = arr[0], r = arr[1];
            if(l < endTime && startTime < r){
                return false;
            }
        }
        for(int[] arr : booked) {
            int l = arr[0], r = arr[1];
            if(l < endTime && startTime < r){
                overlaps.add(new int[]{Math.max(l, startTime),Math.min(r, endTime)});
            }
        }
        booked.add(new int[]{startTime, endTime});
        return true;
    }
}
