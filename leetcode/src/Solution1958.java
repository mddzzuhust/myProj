public class Solution1958 {
    int[] dx = {0, 1, 1, 1, 0, -1, -1,-1};
    int[] dy = {-1, -1, 0, 1, 1, 1, 0,-1};
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        int n = board.length, m = board[0].length;
        board[rMove][cMove] = color;
        for (int i = 0; i < 8; i++) {
            int x = rMove + dx[i], y = cMove + dy[i];
            if(x >= 0 && x < n && y >= 0 && y < m && board[x][y] == color){
                continue;
            }
            while (x >= 0 && x<n && y >= 0 && y < m){
                if(board[x][y] == '.'){
                    break;
                }
                if(board[x][y] == color){
                    return true;
                }
                x += dx[i];
                y += dy[i];
            }
        }
        return false;
    }
}
