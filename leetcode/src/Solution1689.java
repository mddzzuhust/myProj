

public class Solution1689 {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            if (max < c - '0') {
                max = c - '0';
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution1689 s = new Solution1689();
        System.out.println(s.minPartitions("32"));
    }
}
