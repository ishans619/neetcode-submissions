class Solution {
    int parent[];

    public int find(int x){
        if(parent[x] == x){
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public boolean union(int u, int v){
        int pu = find(u);
        int pv = find(v);

        if(pu == pv){
            return false;
        }

        parent[pu] = pv;
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;

        parent = new int[n+1];

        for(int i = 1 ; i <= n ; i++){
            parent[i] = i;
        }

        for(int [] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(!union(u, v)){
                return edge;
            }
        }
        
        return new int[0];
    }
}
