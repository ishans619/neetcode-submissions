class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int result[] = new int[n];

        for(int i = 0 ; i < n ; i++){
            while(!dq.isEmpty() && temperatures[dq.peek()] < temperatures[i]){
                int prev = dq.pop();
                result[prev] = i - prev;
            }
            dq.push(i);
        }
        return result;
    }
}
