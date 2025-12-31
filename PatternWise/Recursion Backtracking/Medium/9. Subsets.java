// https://leetcode.com/problems/subsets/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ls = new ArrayList<>();
        help(nums,0,ls,new ArrayList<>());
        return ls;
    }
    public void help(int[] nums,int idx,List<List<Integer>> ls, List<Integer> temp){
        if(idx==nums.length){
            ls.add(new ArrayList(temp));
            return;
        }
        help(nums,idx+1,ls,temp);
        temp.add(nums[idx]);
        help(nums,idx+1,ls,temp);
        temp.remove(temp.size()-1);
    }
}