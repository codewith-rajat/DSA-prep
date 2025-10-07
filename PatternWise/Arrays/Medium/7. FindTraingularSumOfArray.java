// https://leetcode.com/problems/find-triangular-sum-of-an-array

class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        for(int size=n;size>1;size--){
            for(int i=0;i<size-1;i++){
                nums[i] = (nums[i]+nums[i+1])%10;
            }
        }
        return nums[0];
        // if(n==1) return nums[0];
        // List<Integer> temp = new ArrayList<>();
        // for(int i=0;i<n;i++){
        //     temp.add(nums[i]);
        // }
        // while(temp.size()!=1){
        //     List<Integer> t = new ArrayList<>();
        //     for(int i=0;i<temp.size()-1;i++){
        //         int add = (temp.get(i) + temp.get(i+1))%10;
        //         t.add(add);
        //     }
        //     temp = t;
        // }
        // return temp.get(0);
    }
}