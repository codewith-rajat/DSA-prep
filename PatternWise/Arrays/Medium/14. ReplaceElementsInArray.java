// https://leetcode.com/problems/replace-elements-in-an-array/description/

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<operations.length;i++){
            int old = operations[i][0];
            int neww = operations[i][1];
            int idx = map.get(old);
            nums[idx] = neww;
            map.remove(old);
            map.put(neww,idx);
        }
        return nums;
    }
}