class Solution {

    public void bfs(int [][] heights, Queue<int[]> queue, boolean[][] visited){
        int n = heights.length;
        int m = heights[0].length;

        int drow[] = {-1, 0, 1, 0};
        int dcol[] = {0, 1, 0, -1};

        while(!queue.isEmpty()){
            int [] cell = queue.poll();

            int row = cell[0];
            int col = cell[1];

            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !visited[nrow][ncol] && heights[nrow][ncol] >= heights[row][col]){

                    visited[nrow][ncol] = true;
                    queue.add(new int[]{nrow, ncol});
                }
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        for(int col = 0 ; col < m ; col++){
            pacificQueue.offer(new int[]{0, col});
            pacific[0][col] = true;
        }

        for(int row = 0 ; row < n ; row++){
            pacificQueue.offer(new int[]{row, 0});
            pacific[row][0] = true;
        }

        for(int col = 0 ; col < m ; col++){
            atlanticQueue.offer(new int[]{n-1, col});
            atlantic[n-1][col] = true;
        }

        for(int row = 0 ; row < n ; row++){
            atlanticQueue.offer(new int[]{row, n-1});
            atlantic[row][m-1] = true;
        }

        bfs(heights, pacificQueue, pacific);
        bfs(heights, atlanticQueue, atlantic);

        List<List<Integer>> answer = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(pacific[i][j] && atlantic[i][j]){
                    answer.add(Arrays.asList(i, j));    
                }
            }
        }
        return answer;
    }
}
