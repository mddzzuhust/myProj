package leetcode;

import Greedy.Solution;

public class Solution1668 {
    public int maxRepeating(String sequence, String word) {
        StringBuffer sb = new StringBuffer(word);
        int result = 0;
        while (sequence.contains(sb)){
            result++;
            sb.append(word);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution1668 s = new Solution1668();
        System.out.println(s.maxRepeating("ababc","ac"));
    }
}
