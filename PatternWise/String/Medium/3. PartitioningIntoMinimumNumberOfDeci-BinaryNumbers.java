// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/description/

class Solution {
    public int minPartitions(String n) {
        int maxx = 0;
        for(char ch : n.toCharArray()){
            maxx = Math.max(maxx,ch-'0');
        }
        return maxx;
    }
}