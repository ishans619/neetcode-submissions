class LRUCache {

    class Node{
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    int capacity = 0;
    HashMap<Integer, Node> map;

    Node head, tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void insert(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        Node node = map.get(key);

        remove(node);
        insert(node);

        return node.val;
        
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        Node newNode = new Node(key, value);

        insert(newNode);

        map.put(key, newNode);

        if(map.size() > capacity){
            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }
}
