// https://leetcode.com/contest/biweekly-contest-166/problems/majority-frequency-characters/description/

class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Character,Integer> fre = new HashMap<>();
        for(int i=0;i<s.length();i++){
            fre.put(s.charAt(i),fre.getOrDefault(s.charAt(i),0)+1);
        }
        Map<Integer,List<Character>> group = new HashMap<>();
        for(Map.Entry<Character,Integer> entry : fre.entrySet()){
            int f = entry.getValue();
            group.putIfAbsent(f,new ArrayList<>());
            group.get(f).add(entry.getKey());
        }
        int bestf = -1;
        int bestsize = -1;
        for(Map.Entry<Integer,List<Character>> entry : group.entrySet()){
            int f = entry.getKey();
            int size = entry.getValue().size();
            if(size>bestsize || (size==bestsize && f>bestf)){
                bestf = f;
                bestsize = size;
            }
        }
        String ans = "";
        for(char c : group.get(bestf)){
            ans += c;
        }
        return ans;
    }
}