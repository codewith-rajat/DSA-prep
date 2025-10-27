// https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-ii/description/

class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Map<Integer,Integer> map = new TreeMap<>();
        int maxx = Arrays.stream(nums).max().getAsInt();
        Map<Integer,Integer> freq = new HashMap<>();
        for(int i:nums){
            freq.put(i,freq.getOrDefault(i,0)+1);
            int l = Math.max(i-k,0);
            int r = Math.min(i+k,maxx);
            map.put(l,map.getOrDefault(l,0)+1);
            map.put(r+1,map.getOrDefault(r+1,0)-1);
            map.putIfAbsent(i,0);
        }
        int cumsum = 0;
        int result = 1;
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int e = entry.getKey();
            int f = entry.getValue();
            cumsum += f;
            int targetFreq = freq.getOrDefault(e,0);
            int needed = cumsum - targetFreq;
            int maxPossible = Math.min(needed,numOperations);
            result = Math.max(result,targetFreq + maxPossible);
        }
        return result;
    }
}