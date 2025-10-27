// https://leetcode.com/problems/longest-string-chain/description/

class Solution {
    public int longestStrChain(String[] words) {
        int n = words.length;
        int dp[] = new int[n];
        Arrays.sort(words,(a,b)->a.length()-b.length());
        Arrays.fill(dp,1);
        int maxlen = 1;
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(isPred(words[j],words[i])){
                    dp[i] = Math.max(dp[i],1+dp[j]);
                    maxlen = Math.max(maxlen,dp[i]);
                }
            }
        }
        return maxlen;
    }
    public boolean isPred(String a,String b){
        if(a.length()>=b.length() || b.length()-a.length()!=1) return false;
        int j = 0,i=0;
        while(i<a.length() && j<b.length()){
            if(a.charAt(i)==b.charAt(j)) i++;
            j++;
        }
        return i==a.length();
    }
}