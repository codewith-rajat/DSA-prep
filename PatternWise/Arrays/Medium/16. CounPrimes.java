// https://leetcode.com/problems/count-primes/description/

class Solution {
    public int countPrimes(int n) {
        if(n<=1) return 0;
        boolean prime[] = new boolean[n];
        prime[0] = true;
        prime[1] = true;
        for(int i=2;i<Math.sqrt(n);i++){
            if(!prime[i]){
                    for(int j=i*i;j<n;j+=i){
                    prime[j] = true;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!prime[i]) ans++;
        }
        return ans;
    }
}