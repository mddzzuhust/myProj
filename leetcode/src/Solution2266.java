import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2266 {
    public int countTexts(String pressedKeys) {
        int m = 1000000007;
        int n = pressedKeys.length();
        List<Long> dp3 = new ArrayList<>(Arrays.asList(1L,1L,2L,4L));
        List<Long> dp4 = new ArrayList<>(Arrays.asList(1L,1L,2L,4L));
        for (int i = 4; i <= n; i++) {
            dp3.add((dp3.get(i-1) + dp3.get(i-2) + dp3.get(i-3)) % m);
            dp4.add((dp4.get(i-1) + dp4.get(i-2) + dp4.get(i-3) + dp4.get(i-4)) % m);
        }
        long res = 1;
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            if(pressedKeys.charAt(i) == pressedKeys.charAt(i-1)) {
                ++cnt;
            }else {
                if(pressedKeys.charAt(i-1)=='7' || pressedKeys.charAt(i-1)=='9') {
                    res = (res * dp4.get(cnt)) % m;
                }else {
                    res = (res * dp3.get(cnt)) % m;
                }
                cnt = 1;
            }
        }

        if(pressedKeys.charAt(n-1) == '7' || pressedKeys.charAt(n-1)=='9') {
            res = (res * dp4.get(cnt)) % m;
        }else {
            res = (res * dp3.get(cnt)) % m;
        }
        return (int)res;
    }
}
