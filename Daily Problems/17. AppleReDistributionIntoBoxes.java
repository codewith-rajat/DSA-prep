// https://leetcode.com/problems/apple-redistribution-into-boxes/?envType=daily-question&envId=2025-12-24

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalSum = 0;
        for(int i : apple) totalSum += i;
        int ans = 0;
        for(int i=capacity.length-1;i>=0;i--){
            totalSum -= capacity[i];
            ans++;
            if(totalSum<=0) break;
        }

        return ans;
    }
}