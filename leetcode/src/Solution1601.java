

public class Solution1601 {
    int max = 0;
    public int maximumRequests(int n, int[][] requests) {
        int count = 0;
        int[] lou = new int[n];
        helper(requests,lou,count,0);
        return max;
    }

    public void helper(int[][] requests,int[] lou,int count,int index){
        if(check(lou)){
            max = Math.max(max,count);
        }

        for (int i = index; i < requests.length; i++) {
            lou[requests[i][0]]--;
            lou[requests[i][1]]++;
            count++;
            helper(requests,lou,count,i+1);
            lou[requests[i][0]]++;
            lou[requests[i][1]]--;
            count--;
        }
    }

    public boolean check(int[] lou){
        for (int i = 0; i < lou.length; i++) {
            if(lou[i]!=0)
                return false;
        }
        return true;
    }
}
