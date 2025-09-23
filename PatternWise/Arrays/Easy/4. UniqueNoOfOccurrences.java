// https://leetcode.com/problems/unique-number-of-occurrences

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        Set<Integer> fre = new HashSet<>();
        for(int value : map.values()){
            if(!fre.add(value)) return false;
        }
        return true;
        // set return boolean in .add method return true if value not in set and add it
        // otherwise returns false and don't add it
    }
}