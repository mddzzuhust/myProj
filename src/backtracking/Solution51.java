package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Solution51 {
    public List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] cols = new int[n];
        for (int i=0; i<n; i++) {
            cols[i] = -1;
        }
        backtrack(0, n, cols);
        return res;
    }

    public void  backtrack(int index, int n, int[] cols) {
        if (index == n) {
            res.add(locToList(cols));
            return;
        }

        for (int i=0; i<n; i++) {
            cols[index] = i;
            if (isSafe(cols, index)) {
                backtrack(index+1, n, cols);
            }
            cols[index] = -1;
        }
    }

    public boolean isSafe(int[] cols, int index) {
        for (int i=0; i<index; i++) {
            if (cols[i] == cols[index] || i+cols[i] == index+cols[index] || i-cols[i] == index-cols[index]) {
                return false;
            }
        }
        return true;
    }

    public List<String> locToList(int[] cols) {
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<cols.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<cols[i]; j++){
                sb.append(".");
            }
            sb.append("Q");
            for (int j=cols[i]+1; j<cols.length; j++){
                sb.append(".");
            }
            list.add(sb.toString());
        }
        return list;
    }
}
