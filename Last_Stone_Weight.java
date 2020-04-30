class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) pq.add(stones[i]);
        while(pq.size() > 1) {
            int temp = pq.poll() - pq.poll();
            if(temp != 0) pq.add(temp);
        }
        return pq.size() == 0 ? 0 : pq.peek();
    }
}
