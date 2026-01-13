// https://leetcode.com/problems/largest-prime-from-consecutive-prime-sum/description/

class Solution {
    public int largestPrime(int n){
        boolean[] isPrime = sieve(n);
        List<Integer> primes = new ArrayList<>();
        for(int i=2;i<=n;i++){
            if(isPrime[i]) primes.add(i);
        }
        int sum = 0, ans = 0;
        for(int i : primes){
            sum += i;
            if(sum>n) break;
            if(isPrime[sum]) ans = sum;
        }
        return ans;
    }
    public boolean[] sieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime,true);
        isPrime[0] = false;
        isPrime[1] = false;
        for(int i=2;i*i<=n;i++){
            if(isPrime[i]){
                for(int j=i*i;j<=n;j+=i) isPrime[j] = false;
            }
        }
        return isPrime;
    }
}