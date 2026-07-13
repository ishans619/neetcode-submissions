class Solution {

    public void bfs(int start, ArrayList<ArrayList<Integer>> graph, boolean vis[]){
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            int node = q.poll();

            for(int neighbor : graph.get(node)){
                if(!vis[neighbor]){
                    q.add(neighbor);
                    vis[neighbor] = true;
                }
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[]: edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        boolean vis[] = new boolean[n];
        int count = 0;

        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false){
                count++;
                bfs(i, graph, vis);
            }
        }
        return count;
    }
}
