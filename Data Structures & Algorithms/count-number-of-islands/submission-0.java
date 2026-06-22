class Solution {

    public static void bfs(int row, int col, char [][]grid, boolean vis[][]){
        int n = grid.length;
        int m = grid[0].length;
        vis[row][col] = true;
        Queue<int[]> q = new LinkedList<>();

        vis[row][col] = true;
        q.add(new int[]{row, col});

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int r = cell[0];
            int c = cell[1];

            int drow[] = {-1, 0, 1, 0};
            int dcol[] = {0, 1, 0, -1};

            for(int i = 0 ; i < 4 ; i++){
                int newRow = r + drow[i];
                int newCol = c + dcol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == '1' && !vis[newRow][newCol]){
                    vis[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];

        int count = 0;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    bfs(i, j, grid, vis);
                }
            }
        }
        return count;
    }
}
