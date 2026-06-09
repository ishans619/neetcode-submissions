class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                dist(b),
                dist(a)
            )
        );

        for(int point[] : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int res[][] = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            res[i] = pq.poll();
            i++;
        }
        return res;
    }

    public static int dist(int point[]){
        return point[0] * point[0] + point[1] * point[1];
    }
}
