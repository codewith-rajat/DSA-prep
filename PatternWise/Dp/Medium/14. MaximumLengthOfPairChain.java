// https://leetcode.com/problems/maximum-length-of-pair-chain/description/

class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs,(a,b)->a[0]-b[0]);
        int dp[] = new int[n];
        Arrays.fill(dp,1);
        int maxx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                }
            }
            maxx = Math.max(dp[i],maxx);
        }
        return maxx;
    }
}

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int count = 1;
        int lastEnd = pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(pairs[i][0]>lastEnd) {
                count++;
                lastEnd = pairs[i][1];
            }
        }
        return count;
    }
}