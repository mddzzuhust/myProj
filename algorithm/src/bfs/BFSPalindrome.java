package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSPalindrome {

    public static String getShortestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int m = 2 * n - 1;
        int[][] dp = new int[n][m];

        // Build the table for the longest common subsequence
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s.charAt(i) == reversed.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else if (i > 0 && dp[i - 1][j] > dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        // Use BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[m];
        int start = n - 1;
        int end = 2 * n - 2;
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == end) {
                break;
            }
            if (current - 1 >= 0 && !visited[current - 1]) {
                queue.offer(current - 1);
                visited[current - 1] = true;
            }
            if (current + 1 < m && !visited[current + 1]) {
                queue.offer(current + 1);
                visited[current + 1] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = end; i >= 0; i--) {
            if (dp[n - 1][i] == dp[n - 1][end]) {
                sb.append(reversed.charAt(i));
                end = i - 1;
            }
        }

        return sb.append(s).toString();
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(getShortestPalindrome(s));
    }
}
