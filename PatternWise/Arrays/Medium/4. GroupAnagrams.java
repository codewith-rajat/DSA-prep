// https://leetcode.com/problems/group-anagrams

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String s: strs){
            char []ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedS = new String(ch);
            if(!map.containsKey(sortedS)){
                map.put(sortedS,new ArrayList<>());
            }
            map.get(sortedS).add(s);
        }
        return new ArrayList<>(map.values());
    }
}