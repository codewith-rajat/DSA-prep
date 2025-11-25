// https://leetcode.com/problems/smallest-integer-divisible-by-k/description/?envType=daily-question&envId=2025-11-25

class Solution {
    public int smallestRepunitDivByK(int k) {
        if((k%2==0) || (k%5==0)) return -1;
        int curr = 0,dig = 0;
        for(int i=1;i<=k;i++){
            curr = (curr*10+1)%k;
            dig++;
            if(curr==0) return dig;
        }
        return -1;
    }
}

class Solution {
    public int smallestRepunitDivByK(int k) {
        long curr = 0;
        int dig = 0;
        for(int i=1;i<=k;i++){
            curr = (curr*10+1)%k;
            dig++;
            if(curr==0) return dig;
        }
        return -1;
    }
}