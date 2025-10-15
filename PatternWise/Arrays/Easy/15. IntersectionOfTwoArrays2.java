// https://leetcode.com/problems/intersection-of-two-arrays-ii/description/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int [] present = new int[1001];
        int [] res = new int[Math.min(nums1.length,nums2.length)];
        for(int i : nums1) present[i]++;
        int idx = 0;
        for(int i : nums2){
            if(present[i]!=0){
                res[idx++] = i;
                present[i]--;
            }
        }
        return Arrays.copyOf(res,idx);
    }
}