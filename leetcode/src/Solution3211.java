import java.util.ArrayList;
import java.util.List;

public class Solution3211 {
    List<String> res = new ArrayList<>();
    int n;
    public List<String> validStrings(int n) {
        this.n = n;
        dfs(new StringBuilder());
        return res;
    }

    public void dfs(StringBuilder sb){
        if(sb.length() == n){
            res.add(sb.toString());
        }else {
            if(sb.length() == 0 || sb.charAt(sb.length()-1)=='1'){
                sb.append('0');
                dfs(sb);
                sb.setLength(sb.length()-1);
            }
            sb.append('1');
            dfs(sb);
            sb.setLength(sb.length()-1);
        }
    }
}
