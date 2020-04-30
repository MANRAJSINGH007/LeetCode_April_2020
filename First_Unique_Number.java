class ListNode {
    ListNode next;
    ListNode prev;
    int val;
    ListNode(int val) {
        this.val = val;
    }
}
class FirstUnique {
    static ListNode head;
    static ListNode t;
    static HashMap<Integer, ListNode> map;
    static HashSet<Integer> set;
    public FirstUnique(int[] nums) {
        map = new HashMap<>();
        head = null;
        set = new HashSet<>();
        t = head;
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], new ListNode(nums[i]));
                ListNode curr = map.get(nums[i]);
                if(t == null) {
                    t = curr;
                    head = curr;
                } else {
                    t.next = curr;
                    curr.prev = t;
                    t = t.next;
                }
            } else {
                ListNode curr = map.get(nums[i]);
                map.remove(nums[i]);
                if(curr == head) {
                    head = head.next;
                    if(head != null) head.prev = null;
                    else t = null;
                } else {
                    curr.prev.next = curr.next;
                    if(curr.next == null) t = curr.prev;
                    else curr.next.prev = curr.prev;
                }
                set.add(nums[i]);
            }
        }
    }
    
    public int showFirstUnique() {
        return head == null ? - 1 : head.val;
    }
    
    public void add(int value) {
        if(set.contains(value)) return;
        if(!map.containsKey(value)) {
            map.put(value, new ListNode(value));
            ListNode curr = map.get(value);
            if(t == null) {
                t = curr;
                head = curr;
            } else {
                t.next = curr;
                curr.prev = t;
                t = t.next;
            }
        } else {
            ListNode curr = map.get(value);
            map.remove(value);
            if(curr == head) {
                head = head.next;
                if(head != null) head.prev = null;
                else t = null;
            }
            else {
                curr.prev.next = curr.next;
                if(curr.next == null) t = curr.prev;
                else curr.next.prev = curr.prev;
            }
            set.add(value);
        }
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */
