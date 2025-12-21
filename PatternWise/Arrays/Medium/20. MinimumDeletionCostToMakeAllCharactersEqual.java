// https://leetcode.com/problems/minimum-deletion-cost-to-make-all-characters-equal/description/

class Solution {
    public long minCost(String s, int[] cost) {
        long freq[] = new long[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq[ch-'a'] += cost[i]; 
        }
        long sum = 0;
        long maxx = Arrays.stream(freq).max().getAsLong();
        for(int i=0;i<26;i++){
            sum += freq[i];
        }
        sum -= maxx;
        return sum;
    }
}