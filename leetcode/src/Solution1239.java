

import java.util.List;

public class Solution1239 {
    public int maxLength(List<String> arr) {
        return dfs(arr, 0, 0);
    }

    public int dfs(List<String> arr, int index, int flag) {
        if (index >= arr.size()) {
            return 0;
        }
        int max = 0;
        for (int i = index; i < arr.size(); i++) {
            int f = 0;
            String str = arr.get(i);
            for (char c : str.toCharArray()) {
                if((f&1<<(c-'a'))!=0){
                    f = 0;
                    break;
                }
                f |= 1<<(c-'a');
            }
            if(f==0||(flag&f)!=0){
                continue;
            }
            max = Math.max(max,str.length()+dfs(arr,i+1,flag|f));
        }
        return max;
    }
}
