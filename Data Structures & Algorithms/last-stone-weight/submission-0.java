class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int max = pq.poll();
            int secondMax = pq.poll();
            int diff = max - secondMax;
            if(diff != 0){
                pq.offer(diff);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}
