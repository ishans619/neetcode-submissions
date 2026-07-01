class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        if(fresh == 0){
            return 0;
        }

        int minutes = 0;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while(!q.isEmpty()){
            int size = q.size();
            boolean rottedThisMinute = false;

            for(int i = 0 ; i < size ; i++){
                int cell[] = q.poll();
                int row = cell[0];
                int col = cell[1];

                for(int d = 0 ; d < 4 ; d++){
                    int nrow = row + drow[d];
                    int ncol = col + dcol[d];

                    if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] = 2;
                        fresh--;
                        q.offer(new int[]{nrow, ncol});
                        rottedThisMinute = true;
                    }
                }
            }

            if(rottedThisMinute){
                minutes++;
            }
        }
        
        if(fresh > 0){
            return -1;
        }
        return minutes;
    }
}
