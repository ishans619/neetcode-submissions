class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0;
        int right = n-1;
        int maxArea = Integer.MIN_VALUE;

        while(left < right){
            int width = right - left;
            int currHeight = Math.min(heights[left], heights[right]);
            int area = currHeight * width;

            maxArea = Math.max(area, maxArea);

            if(heights[left] < heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
