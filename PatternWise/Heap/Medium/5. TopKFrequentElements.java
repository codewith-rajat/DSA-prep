// https://leetcode.com/problems/top-k-frequent-elements

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap<>();
        for(int ele : nums){
            freq.put(ele,freq.getOrDefault(ele,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        for(Map.Entry<Integer,Integer> entry : freq.entrySet()){
            int ele = entry.getKey();
            int fre = entry.getValue();
            pq.add(new int[]{ele,fre});
            if(pq.size()>k) pq.poll();
        }
        int res [] = new int[k];
        int idx= k-1 ;
        while(pq.size()>0){
            res[idx--] = pq.poll()[0];
        }
        return res;
    }
}