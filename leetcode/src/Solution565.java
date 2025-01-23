import java.util.HashSet;
import java.util.Set;

public class Solution565 {
    boolean[] visited = new boolean[100000];

    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int index = getNotVisitedIndex(visited,n);
        int result = 0;
        while(index >= 0 ){
            int count = getNumSetCount(nums, visited, index);
            if(result < count){
                result = count;
            }
            index = getNotVisitedIndex(visited,n);
        }
        return result;
    }

    private int getNumSetCount(int[] nums, boolean[] visited, int index){
        Set<Integer> numSet = new HashSet<Integer>();
        int num = nums[index];
        while(!numSet.contains(num)){
            visited[num] = true;
            numSet.add(num);
            num = nums[num];
        }
        return numSet.size();
    }

    private int getNotVisitedIndex(boolean[] visited,int n){
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution565 solution = new Solution565();
        System.out.println(solution.arrayNesting(new int[]{5,4,0,3,1,6,2}));
    }
}
