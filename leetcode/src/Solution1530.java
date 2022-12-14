

public class Solution1530 {
    int result = 0;
    public int countPairs(TreeNode root, int distance) {
        int[] res = func(root,distance);
        return result;
    }

    private int[] func(TreeNode node,int distance){
        if(node.left==null&&node.right==null){
            return new int[]{0};
        }
        if(node.left!=null&&node.right==null){
            int[] pathLeft = func(node.left,distance);
            for (int i = 0; i < pathLeft.length; i++) {
                pathLeft[i] = pathLeft[i]+1;
            }
            return pathLeft;
        }else if(node.left==null&&node.right!=null){
            int[] pathRight = func(node.right,distance);
            for (int i = 0; i < pathRight.length; i++) {
                pathRight[i] = pathRight[i]+1;
            }
            return pathRight;
        }else{
            int[] pathLeft = func(node.left,distance);
            for (int i = 0; i < pathLeft.length; i++) {
                pathLeft[i] = pathLeft[i]+1;
            }
            int[] pathRight = func(node.right,distance);
            for (int i = 0; i < pathRight.length; i++) {
                pathRight[i] = pathRight[i]+1;
            }
            for (int i = 0; i < pathLeft.length; i++) {
                for (int j = 0; j < pathRight.length; j++) {
                    if(pathLeft[i]+pathRight[j]<=distance){
                        result++;
                    }
                }
            }
            int[] path = new int[pathLeft.length+pathRight.length];
            for (int i = 0; i < pathLeft.length; i++) {
                path[i] = pathLeft[i];
            }
            for (int i = 0; i < pathRight.length; i++) {
                path[pathLeft.length+i] = pathRight[i];
            }
            return path;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
