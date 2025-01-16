package graph;

import java.util.ArrayList;
import java.util.List;
/*
* 拓扑排序是对一个有向无环图（DAG）的所有顶点进行线性排序，
* 使得对于图中的每一条有向边 (u, v)，顶点 u 在排序结果中出现在顶点 v 之前。
* 拓扑排序的算法通常有两种实现方式：基于Kahn算法（使用队列）和基于深度优先搜索（DFS）
* */
import java.util.*;

public class KahnTopologicalSort {
    public static List<Integer> topologicalSort(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] inDegree = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        // 初始化邻接表和入度数组
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prerequisiteCourse = prerequisite[1];
            adjList.get(prerequisiteCourse).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // 将入度为0的顶点加入队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            result.add(currentCourse);

            for (int neighbor : adjList.get(currentCourse)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 如果结果集中的元素数量不等于课程数量，说明存在环
        if (result.size() != numCourses) {
            return new ArrayList<>(); // 返回空列表表示存在环
        }

        return result;
    }

    public static void main(String[] args) {
        int numCourses = 6;
        int[][] prerequisites = {{5, 2}, {5, 0}, {4, 0}, {4, 1}, {2, 3}, {3, 1}};
        List<Integer> topoSort = topologicalSort(numCourses, prerequisites);
        System.out.println("拓扑排序结果: " + topoSort);
    }
}

