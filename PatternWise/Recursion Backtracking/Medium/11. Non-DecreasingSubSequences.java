// https://leetcode.com/problems/non-decreasing-subsequences/description/

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        help(nums,0,new ArrayList<>(),set);
        List<List<Integer>> ls = new ArrayList<>(set);
        return ls;
    }
    public void help(int [] nums, int idx, List<Integer> temp, Set<List<Integer>> used){
        if(temp.size()>=2){
            used.add(new ArrayList(temp));
        }
        if(idx==nums.length) return;
        if(temp.size()==0 || nums[idx]>=temp.get(temp.size()-1)) {
            temp.add(nums[idx]);
            help(nums,idx+1,temp,used);
            temp.remove(temp.size()-1);
        }
        help(nums,idx+1,temp,used);
    }
}