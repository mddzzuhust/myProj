package graph;

import java.util.*;

/*
 * 拓扑排序是对一个有向无环图（DAG）的所有顶点进行线性排序，
 * 使得对于图中的每一条有向边 (u, v)，顶点 u 在排序结果中出现在顶点 v 之前。
 * 拓扑排序的算法通常有两种实现方式：基于Kahn算法（使用队列）和基于深度优先搜索（DFS）
 * */
public class DFSTopologicalSort {
    private static List<Integer> result = new ArrayList<>();
    private static boolean[] visited;
    private static boolean[] recursionStack;
    private static Map<Integer, List<Integer>> adjList;

    public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        adjList = new HashMap<>();
        visited = new boolean[numCourses];
        recursionStack = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjList.get(prerequisiteCourse).add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i);
            }
        }

        Collections.reverse(result); // DFS的拓扑排序结果需要反转

        return result;
    }

    private static void topologicalSortUtil(int vertex) {
        visited[vertex] = true;
        recursionStack[vertex] = true;

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                topologicalSortUtil(neighbor);
            } else if (recursionStack[neighbor]) {
                // 如果发现已访问的顶点又在递归栈中，说明存在环
                result.clear();
                return;
            }
        }

        recursionStack[vertex] = false;
        result.add(vertex);
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        List<Integer> topoSort = topologicalSort(numCourses, prerequisites);
        System.out.println("拓扑排序结果: " + topoSort);
    }
}

