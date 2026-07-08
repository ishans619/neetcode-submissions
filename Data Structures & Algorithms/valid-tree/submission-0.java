class Solution {

    public boolean dfs(int node, int parent, Set<Integer> visited, ArrayList<ArrayList<Integer>> graph){
        if(visited.contains(node)){
            return false;
        }

        visited.add(node);

        for(int neighbor : graph.get(node)){
            if(neighbor == parent){
                continue;
            }

            if(!dfs(neighbor, node, visited, graph)){
                return false;
            }
        }
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }

        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        Set<Integer> visited = new HashSet<>();

        if(!dfs(0, -1, visited, graph)){
            return false;
        }

        return visited.size() == n;
    }
}
