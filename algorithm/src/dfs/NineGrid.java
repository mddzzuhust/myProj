package dfs;

/*
* 九宫格是一个99的棋盘，我们在其中放置数字，要求每行、每列、以及每个33的格子内都不能有重复的数字。
**/

public class NineGrid {
    private int[][] board = new int[9][9];
    private boolean[] row = new boolean[9];
    private boolean[] col = new boolean[9];
    private boolean[] box = new boolean[9];

    public void solveNineGrid() {
        dfs(0);
    }

    private boolean dfs(int i) {
        if (i >= 9) {
            return true;
        }
        int i0 = i / 3;
        int j0 = i % 3;
        for (int num = 1; num <= 9; num++) {
            if (isValid(i, num)) {
                board[i0][j0] = num;
                row[i0] = col[j0] = box[i0 / 3 * 3 + j0 / 3] = true;
                if (dfs(i + 1)) {
                    return true;
                }
                board[i0][j0] = 0;
                row[i0] = col[j0] = box[i0 / 3 * 3 + j0 / 3] = false;
            }
        }
        return false;
    }

    private boolean isValid(int i, int num) {
        int i0 = i / 3;
        int j0 = i % 3;
        return !row[i0] && !col[j0] && !box[i0 / 3 * 3 + j0 / 3] && board[i0][j0] == 0;
    }

    public void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        NineGrid nineGrid = new NineGrid();
        nineGrid.solveNineGrid();
        nineGrid.printBoard();
    }
}
