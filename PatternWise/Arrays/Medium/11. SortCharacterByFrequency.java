// https://leetcode.com/problems/sort-characters-by-frequency/description/

class Solution {
    public String frequencySort(String s) {
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());

        Map<Character,Integer> freq = new HashMap<>();

        for(char ch : s.toCharArray()){
            freq.put(ch,freq.getOrDefault(ch,0)+1);
        }

        for(Map.Entry<Character,Integer> entry : freq.entrySet()){
            pq.add(entry);
        }
        
        StringBuilder ans = new StringBuilder();
        while(pq.size()>0){
            Map.Entry<Character,Integer> entry = pq.poll();
            char ch = entry.getKey();
            int f = entry.getValue();
            while(f-->0) ans.append(ch);
        }
        return ans.toString();
    }
}