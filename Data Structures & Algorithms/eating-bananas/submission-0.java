class Solution {
    public boolean canFinish(int piles[], int mid, int h){
        int hours = 0;
        for(int pile : piles){
            hours += (pile+mid-1)/mid;
        }
        return hours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while(left < right){
            int mid = left + (right - left)/2;

            if(canFinish(piles, mid, h)){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        } 
        return left;
    }
}
