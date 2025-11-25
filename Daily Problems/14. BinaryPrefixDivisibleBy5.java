// https://leetcode.com/problems/binary-prefix-divisible-by-5/description/?envType=daily-question&envId=2025-11-24/

class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ls = new ArrayList<>();
        int curr = 0;
        for(int i:nums){
            curr = (curr*2 + i)%5;
            if(curr == 0) ls.add(true);
            else ls.add(false);
        }
        return ls;
    }
}