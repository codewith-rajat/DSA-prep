// https://leetcode.com/problems/count-partitions-with-even-sum-difference/?envType=daily-question&envId=2025-12-05

class Solution {
    public int countPartitions(int[] nums) {
        int[] pre = new int[nums.length];
        pre[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            pre[i] = pre[i-1] + nums[i];
        }
        int c=0;
        int total = pre[nums.length-1];
        for(int i=0;i<nums.length-1;i++){
            if(Math.abs((total-pre[i]) - pre[i])%2==0){
                c++;
            }
        }
        return c;
    }
}