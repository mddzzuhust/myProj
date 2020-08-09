package leetcode;

public class Solution1528 {
    public String restoreString(String s, int[] indices) {
        char[] result = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            result[indices[i]] = s.charAt(i);
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            res.append(result[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution1528 s =new Solution1528();
        String str = "codeleet";
        int[] indices = new int[]{4,5,6,7,0,2,1,3};
        System.out.println(s.restoreString(str,indices));
    }
}
