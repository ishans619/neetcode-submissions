/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node clonedNode = new Node(node.val);
        map.put(node, clonedNode);

        q.add(node);

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(Node neighbor: curr.neighbors){

                if(!map.containsKey(neighbor)){
                    Node clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor, clonedNeighbor);
                    q.add(neighbor);
                }

                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}