// https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/description/

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        int maxx = Arrays.stream(nums).max().getAsInt();
        int diff[] = new int[maxx+2];
        int freq[] = new int[maxx+1];
        for(int i:nums){
            freq[i]++;
            int l = Math.max(i-k,0);
            int r = Math.min(i+k,maxx);
            diff[l]++;
            diff[r+1]--;
        }
        int result = 1;
        for(int t=0;t<=maxx;t++){
            diff[t] += t>0 ? diff[t-1] : 0;
            int targetFreq = freq[t];
            int neededFreq = diff[t] - targetFreq;
            int maxPossible = Math.min(neededFreq,numOperations);
            result = Math.max(result,targetFreq+maxPossible);
        }
        return result;
    }
}