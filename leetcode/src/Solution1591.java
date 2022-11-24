

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution1591 {
    class Node{
        int left;
        int up;
        int right;
        int bottom;

        Node(int a,int b,int c,int d){
            left = a;
            up = b;
            right = c;
            bottom = d;
        }
    }

    public boolean isPrintable(int[][] targetGrid){
        Map<Integer,Node> colorPos = new HashMap<>();
        int m = targetGrid.length;
        int n = targetGrid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int color = targetGrid[i][j];
                if(colorPos.containsKey(color)){
                    Node  node = colorPos.get(color);
                    node.bottom  = Math.max(node.bottom,i);
                    node.up = Math.min(node.up,i);
                    node.left = Math.min(node.left,j);
                    node.right = Math.max(node.right,j);
                }else {
                    colorPos.put(color,new Node(j,i,j,i));
                }
            }
        }
        Set<Integer> colors = new HashSet<>(colorPos.keySet());
        while (!colors.isEmpty()){
            Set<Integer> deletion = new HashSet<>();
            for (int c : colors){
                if(isOneColor(targetGrid,colorPos.get(c),c))
                    deletion.add(c);
            }
            if(deletion.isEmpty()){
                return false;
            }
            colors.removeAll(deletion);
        }
        return true;
    }

    private boolean isOneColor(int[][] targetGrid,Node boundary,int color){
        for (int i = boundary.up; i <= boundary.bottom; i++) {
            for (int j = boundary.left; j <= boundary.right; j++) {
                if(targetGrid[i][j]>0 && targetGrid[i][j]!=color)
                    return false;
            }
        }

        for (int i = boundary.up; i <= boundary.bottom ; i++) {
            for (int j = boundary.left; j <= boundary.right; j++) {
                targetGrid[i][j] = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1591 s = new Solution1591();
        int[][] target = new int[][]{{1,2,1},{2,1,2},{1,2,1}};
        System.out.println(s.isPrintable(target));
    }
}
