// https://leetcode.com/problems/four-divisors/

class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0,n = nums.length;
        for(int i=0;i<n;i++){
            int end = (int)Math.sqrt(nums[i]);
            List<Integer> ls = new ArrayList<>();
            for(int j=1;j<=end;j++){
                if(nums[i]%j==0) {
                    ls.add(j);
                    if(nums[i]/j!=j) ls.add(nums[i]/j);
                }
            }
            if(ls.size()==4){
                int sum = 0;
                for(int k=0;k<ls.size();k++) sum += ls.get(k);
                ans += sum;
            }
        }
        return ans;
    }
}