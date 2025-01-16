package bfs;

//迷宫最短路径
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPath {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private char[][] maze;
    private boolean[][] visited;
    private int rows;
    private int cols;

    public ShortestPath(char[][] maze) {
        this.maze = maze;
        this.rows = maze.length;
        this.cols = maze[0].length;
        this.visited = new boolean[rows][cols];
    }

    public boolean solveMaze(int startRow, int startCol, int endRow, int endCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            if (cell[0] == endRow && cell[1] == endCol) {
                return true;
            }

            for (int[] direction : DIRECTIONS) {
                int nextRow = cell[0] + direction[0];
                int nextCol = cell[1] + direction[1];
                if (isValidCell(nextRow, nextCol) && !visited[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.offer(new int[]{nextRow, nextCol});
                }
            }
        }
        return false;
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols && maze[row][col] != '#';
    }

    // 测试代码
    public static void main(String[] args) {
        char[][] maze = {
                {'#', '#', '#', '#', '#'},
                {'#', ' ', ' ', '#', '#'},
                {'#', ' ', ' ', '#', '#'},
                {'#', ' ', ' ', '#', '#'},
                {'#', '#', '#', '#', '#'}
        };

        ShortestPath solver = new ShortestPath(maze);
        boolean hasPath = solver.solveMaze(1, 1, 3, 3);
        System.out.println("Has path: " + hasPath);
    }
}
