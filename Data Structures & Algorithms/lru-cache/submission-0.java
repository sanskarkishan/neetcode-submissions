class LRUCache {

    /*
LRU CACHE - APPROACH

HashMap:
- Stores key -> node mapping.
- Provides O(1) access to cache entries.

Doubly Linked List:
- Maintains usage order.
- Allows O(1) insertion and deletion.

head <-> ... <-> tail

head.next = Least Recently Used (LRU)
tail.prev = Most Recently Used (MRU)

Rules:
- Accessed node -> move to tail.
- New node -> add at tail.
- Capacity exceeded -> remove node next to head.

GET OPERATION:
1. Check if key exists.
2. If not, return -1.
3. Get node from map.
4. Remove node from current position.
5. Add node at tail.
6. Return value.

PUT OPERATION:
If key exists:
1. Remove old node from DLL.
2. Create updated node.
3. Store in map.
4. Add at tail.

If key does not exist:
1. Create node.
2. Add to map.
3. Add to tail.

Capacity Check:
- If map size exceeds capacity:
  1. Remove node next to head.
  2. Remove its key from map.

HELPER METHODS:

removeFromTheList(node)
A <-> node <-> B
becomes
A <-> B

addAtTail(node)
prev <-> tail
becomes
prev <-> node <-> tail

deleteAtHead()
head <-> LRU <-> ...
Removes and returns the least recently used node.

EXAMPLE:

Capacity = 2

put(1,10)
head <-> [1] <-> tail

put(2,20)
head <-> [1] <-> [2] <-> tail

get(1)
head <-> [2] <-> [1] <-> tail

put(3,30)
Remove LRU = [2]

head <-> [1] <-> [3] <-> tail

COMPLEXITY:

get(key)     : O(1)
put(key,val) : O(1)

Space: O(capacity)

Key Idea:
HashMap provides O(1) lookup.
Doubly Linked List provides O(1) insertion/deletion.
Combining both achieves O(1) get() and put().
*/

    private class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        removeFromTheList(node);
        addAtTail(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)){
            removeFromTheList(map.get(key));
        }
        Node node = new Node(key, value);
        map.put(key, node);
        addAtTail(node);

        if (map.size() > capacity){
            Node lru = deleteAtHead();
            map.remove(lru.key);
        }
    }

    private void removeFromTheList(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addAtTail(Node node) {
        Node prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;
    }

    private Node deleteAtHead() {
        Node lru = head.next;
        removeFromTheList(lru);
        return lru;
    }
}
