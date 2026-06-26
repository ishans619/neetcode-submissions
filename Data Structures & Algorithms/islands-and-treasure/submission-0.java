class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 0){
                    q.add(new int[]{i, j});
                }
            }
        }

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int curr[] = q.poll();
            int row = curr[0];
            int col = curr[1];

            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && 
                ncol < m  && grid[nrow][ncol] == 2147483647){
                    grid[nrow][ncol] = grid[row][col] + 1;
                    q.add(new int[]{nrow, ncol});
                }
            }
        }
    }
}
