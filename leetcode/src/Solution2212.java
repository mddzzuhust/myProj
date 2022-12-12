import java.util.Arrays;

public class Solution2212 {
    int max = 0;
    int[] ans = new int[12];
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        dfs(aliceArrows,0,numArrows,0,new int[12]);
        return ans;
    }

    void dfs(int[] nums, int idx, int res, int point, int[] cur){
        if(idx == 11){
            if(point > max){
                max = point;
                ans = Arrays.copyOf(cur, cur.length);
                if(res > 0){
                    ans[0] = res;
                }
            }
            return;
        }

        if(res > nums[idx+1]){
            cur[idx+1] = nums[idx+1]+1;
            dfs(nums, idx+1, res-nums[idx+1]-1,point+idx+1,cur);
        }
        cur[idx+1] = 0;
        dfs(nums,idx+1,res,point,cur);
    }
}
