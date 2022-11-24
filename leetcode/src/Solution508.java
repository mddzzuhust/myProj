

import java.util.HashMap;
import java.util.Map;

public class Solution508 {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    Map<Integer,Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        int max = -1;
        for(int val:map.values()){
            if(val>max){
                max=val;
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==max){
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue()==max){
                result[index++] = entry.getKey();
            }
        }
        return result;
    }
    private int dfs(TreeNode node){
        if(node==null)
            return 0;
        if(node.left==null&&node.right==null){
            if(map.containsKey(node.val)){
                int count = map.get(node.val);
                map.put(node.val, count+1);
            }else {
                map.put(node.val,1);
            }
            return node.val;
        }

        int value = node.val + dfs(node.left) + dfs(node.right);
        if(map.containsKey(value)){
            int count = map.get(value);
            map.put(value,count+1);
        }else {
            map.put(value,1);
        }
        return value;
    }
}
