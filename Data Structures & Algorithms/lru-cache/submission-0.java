class LRUCache {

    class Node {
        int key;
        int value;
        Node left;
        Node right;
    }
    Map<Integer, Node> cache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            Node valueAtKey = cache.get(key);
            mruNodeAtEnd(valueAtKey);
            return valueAtKey.value;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node existingNode = cache.get(key);
            existingNode.value = value;
            mruNodeAtEnd(existingNode);
        }
        else if(cache.size() == capacity){
            Node putInCache = new Node();
            putInCache.key = key;
            putInCache.value = value;
            removeFirst(head);
            cache.put(key, putInCache);
            addToTail(putInCache);
        }
        else if(cache.size() < capacity){
            Node putInCache = new Node();
            putInCache.key = key;
            putInCache.value = value;
            cache.put(key, putInCache);
            addToTail(putInCache);
        }
        else return;
    }

    public void addToTail(Node tailNode){
        tailNode.right = null;
        if(head == null && tail == null){
            tailNode.left = null;
            head = tailNode;
            tail = tailNode;
        }
        else{
            tailNode.left = tail;
            tail.right = tailNode;
            tail = tailNode;
        }
    }

    public void mruNodeAtEnd(Node getNode){
        if (getNode.right == null) {
            return;
        }
        removeNode(getNode);
        addToTail(getNode);

    }

    public void removeFirst(Node firstNode){
        if(capacity == 0){
            return;
        }
        if(firstNode.right == null){
            head = null;
            tail = null;
            cache.remove(firstNode.key);
        }
        else{
            removeNode(firstNode);
            cache.remove(firstNode.key);
        }
    }

    public void removeNode(Node node) {
        if(node.left == null && node.right == null){
            return;
        }
        else if(node.left == null && node.right != null){
            Node tempRight = node.right;
            tempRight.left = null;
            head = tempRight;
        }
        else if(node.left != null && node.right == null) return;
        else{
            Node tempLeft = node.left;
            Node tempRight = node.right;
            tempRight.left = tempLeft;
            tempLeft.right = tempRight;
        }
    }
}
