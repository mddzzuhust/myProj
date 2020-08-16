package leetcode;

import java.util.*;

public class SolutionOffer32 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if(root==null)
            return ans;
        boolean flag = false;

        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        list.add(root.val);
        if(root.left!=null){
            stack.push(root.left);
        }
        if(root.right!=null){
            stack.push(root.right);
        }
        ans.add(list);
        while(stack!=null&&stack.size()!=0) {
            List<Integer> list1 = new LinkedList<>();
            Stack<TreeNode> stack1 = new Stack<>();
            if (flag == false){
                while (stack != null && stack.size() != 0) {
                    TreeNode node = stack.pop();
                    list1.add(node.val);
                    if(node.right!=null){
                        stack1.push(node.right);
                    }
                    if(node.left!=null){
                        stack1.push(node.left);
                    }
                }
            }else {
                while (stack != null && stack.size() != 0) {
                    TreeNode node = stack.pop();
                    list1.add(node.val);
                    if(node.left!=null){
                        stack1.push(node.left);
                    }
                    if(node.right!=null){
                        stack1.push(node.right);
                    }
                }
            }
            ans.add(list1);
            stack = stack1;
            flag = !flag;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);

        node.left = node1;
        node.right = node2;
        node2.left = node3;
        node2.right = node4;
        SolutionOffer32 s = new SolutionOffer32();
        System.out.println(s.levelOrder(node));
        System.out.println(s.levelOrder(node).size());
    }
}
