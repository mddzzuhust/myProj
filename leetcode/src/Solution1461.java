import java.util.HashSet;
import java.util.Set;

public class Solution1461 {
    public boolean hasAllCodes(String s, int k) {
        if(s.length() < (1<<k)+k-1){
            return false;
        }

        Set<String> exists = new HashSet<String>();
        for (int i = 0; i+k <= s.length(); i++) {
            exists.add(s.substring(i,i+k));
        }

        return exists.size() == (1<<k);
    }
}
