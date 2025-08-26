// https://leetcode.com/problems/kth-largest-element-in-an-array/description/   25-8-25

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>k){
                pq.poll();
            }
        } 
        return pq.poll();
    }
}