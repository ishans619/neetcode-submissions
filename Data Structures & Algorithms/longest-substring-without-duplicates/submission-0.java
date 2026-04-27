class Solution {
    public int lengthOfLongestSubstring(String s) {
        int resL = 0;
        int left = 0;
        int right = 0;
        HashSet<Character> set = new HashSet<>();

        while(right < s.length()){
            char i = s.charAt(right);

            if(!set.contains(i)){
                set.add(i);
                resL = Math.max(resL, right - left + 1);
                right++;
            }
            else{
                set.remove(s.charAt(left));
                left++;
            }
        }
        return resL;
    }
}
