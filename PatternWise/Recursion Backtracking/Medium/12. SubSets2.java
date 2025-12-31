// https://leetcode.com/problems/subsets-ii/description/?envType=problem-list-v2&envId=backtracking

class Solution {
    public void set(int [] nums,int index,List<Integer>k,List<List<Integer>> res){
        if(index==nums.length){
            res.add(new ArrayList<Integer> (k));
            return;
        }
        k.add(nums[index]);
        set(nums,index+1,k,res);
        k.remove(k.size()-1);
        int nextIndex = index;
        while(nextIndex+1<nums.length && nums[nextIndex]==nums[nextIndex+1]) nextIndex++;
        set(nums,nextIndex+1,k,res);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> k = new ArrayList<>();
        Arrays.sort(nums); //to handle duplicates
        set(nums,0,k,res);
        return res;
    }
}