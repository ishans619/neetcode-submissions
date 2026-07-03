class Solution {

    public void dfs(int row, int col, char[][]board){
        int n = board.length;
        int m = board[0].length;

        if(row < 0 || row >= n || col < 0 || col >= m || board[row][col] != 'O'){
            return;
        }

        board[row][col] = '#';

        dfs(row - 1, col, board);
        dfs(row, col + 1, board);
        dfs(row + 1, col, board);
        dfs(row, col - 1, board);   
    }


    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int row = 0 ; row < m ; row++){
            if(board[0][row] == 'O'){
                dfs(0, row, board);
            }
        }

        for(int row = 0 ; row < m ; row++){
            if(board[n-1][row] == 'O'){
                dfs(n-1, row, board);
            }
        }

        for(int col = 0 ; col < n ; col++){
            if(board[col][0] == 'O'){
                dfs(col, 0, board);
            }
        }

        for(int col = 0 ; col < n ; col++){
            if(board[col][m-1] == 'O'){
                dfs(col, m-1, board);
            }
        }

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }

                else if(board[i][j] == '#'){
                    board[i][j] = 'O';
                }
            }
        }   
    }
}
