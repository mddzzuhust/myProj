import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution3181 {
    public int maxTotalReward(int[] rewardValues) {
        int m = 0;
        for(int v : rewardValues){
            m = Math.max(m,v);
        }
        Set<Integer> set = new HashSet<>();
        for(int v : rewardValues){
            if(v==m-1){
                return m*2-1;
            }
            if(set.contains(v)){
                continue;
            }
            if(set.contains(m-1-v)){
                return m*2-1;
            }
            set.add(v);
        }
        Arrays.sort(rewardValues);
        int pre = 0;
        BigInteger f = BigInteger.ONE;
        for(int v : rewardValues){
            if(v==pre){
                continue;
            }
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
            pre = v;
        }
        return f.bitLength()-1;
    }
}
