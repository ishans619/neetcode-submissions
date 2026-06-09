class Solution {
    public int leastInterval(char[] tasks, int n) {
        int mp[] = new int[26];

        for(char task : tasks){
           mp[task - 'A']++; 
        }

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i < 26 ; i++){
            if(mp[i] > 0){
                pq.offer(mp[i]);
            }
        }

        while(!pq.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();

            for(int i = 0 ; i < n + 1 ; i++){
                if(!pq.isEmpty()){
                    int freq = pq.peek();
                    pq.poll();
                    freq--;
                    temp.add(freq);
                }
            }

            for(int i : temp){
                if(i > 0){
                    pq.offer(i);
                }
            }

            if(pq.isEmpty()){
                time += temp.size();
            }
            else{
                time += n+1;
            }
        }

        return time;
    }
}
