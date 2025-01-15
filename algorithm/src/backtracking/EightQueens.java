package backtracking;

public class EightQueens {
    static int[] solution = new int[8];
    static int count = 0;

    public static void main(String[] args) {
        solve(0);
        System.out.println("Total number of solutions: " + count);
    }

    public static void solve(int row) {
        if (row == 8) {
            printSolution();
            return;
        }

        for (int col = 0; col < 8; col++) {
            if(isSafe(row, col, solution)){
                solution[row] = col;
                solve(row + 1);
                solution[row] = -1;
            }
        }
    }

    public static boolean isSafe(int row, int col, int[] arr) {
        for (int i = 0; i < row; i++) {
            if (arr[i] == col) {
                return false;
            }
            if (i + arr[i] == row + col) {
                return false;
            }
            if (i - arr[i] == row - col) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution() {
        count++;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (solution[i] == j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
