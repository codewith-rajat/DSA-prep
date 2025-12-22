// https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/

class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int ans = 0,dist = 0,l=0,r=0,n=nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        dist = (int)Arrays.stream(nums).distinct().count();
        while(r<n){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.size()==dist){
                ans += n-r;
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            r++;
        }
        return ans;
    }
}