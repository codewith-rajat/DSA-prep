// https://leetcode.com/problems/find-occurrences-of-an-element-in-an-array/description/

class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<nums.length;i++) if(nums[i]==x) ls.add(i);
        for(int i=0;i<queries.length;i++){
            if(queries[i]<=ls.size()) queries[i] = ls.get(queries[i]-1);
            else queries[i] = -1;
        }
        return queries;
    }
}