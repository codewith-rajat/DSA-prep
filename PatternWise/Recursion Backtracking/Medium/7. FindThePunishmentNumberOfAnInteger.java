// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/?envType=problem-list-v2&envId=backtracking

class Solution {
    public int punishmentNumber(int n) {
        int ans = 0;
        for(int i=1;i<=n;i++){
            if(help(i,String.valueOf(i*i),0,0)) ans += i*i;
        }
        return ans;
    }
    public boolean help(int target, String numSq,int idx,int sum){
        if(idx==numSq.length()){
            return sum==target;
        }
        int num = 0;
        for(int i=idx;i<numSq.length();i++){
            num = num * 10 + (numSq.charAt(i)-'0');
            if(sum+num>target) break;
            if(help(target,numSq,i+1,sum+num)) return true;
        }
        return false;
    }
}
