class ListNode {
    ListNode next;
    ListNode prev;
    int key;
    int val;
    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
class LRUCache {

    static HashMap<Integer, ListNode> map;
    int maxSize;
    ListNode head;
    ListNode tail;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        maxSize = capacity;
        head = null;
        tail = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        ListNode x = map.get(key);
        if(x != head) {
            ListNode y = x.next;
            ListNode z = x.prev;
            z.next = y;
            if(y != null) y.prev = z;
            else tail = z;
            head.prev = x;
            x.next = head;
            x.prev = null;
            head = x;
        } 
        return x.val;
    }
    
    public void put(int key, int val) {
        if(map.containsKey(key)) {
            map.get(key).val = val;
            if(map.get(key) == head) return;
            ListNode x = map.get(key);
            ListNode y = x.next;
            ListNode z = x.prev;
            z.next = y;
            if(y != null) y.prev = z;
            else tail = z;
            head.prev = x;
            x.next = head;
            x.prev = null;
            head = x;
        } else {
            if(map.size() != maxSize) {
                ListNode x = new ListNode(key, val);
                map.put(key, x);
                x.next = head;
                if(head != null) head.prev = x;
                else tail = x;
                head = x;
            } else {
                if(tail == null) {
                    ListNode x = new ListNode(key, val);
                    map.put(key, x);
                    head = x;
                    tail = x;
                    return;
                }
                map.remove(tail.key);
                tail = tail.prev;
                if(tail != null) {
                    ListNode x = new ListNode(key, val);
                    map.put(key, x);
                    tail.next = null;
                    x.next = head;
                    head.prev = x;
                    head = x;
                    return;
                }
                ListNode x = new ListNode(key, val);
                map.put(key, x);
                head = x;
                tail = x;
                return;
            }
        }
    }
}
