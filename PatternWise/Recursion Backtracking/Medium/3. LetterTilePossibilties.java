// https://leetcode.com/problems/letter-tile-possibilities/?envType=problem-list-v2&envId=backtracking

class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character,Integer> mp = new HashMap<>();
        for(char ch : tiles.toCharArray()) mp.put(ch,mp.getOrDefault(ch,0)+1);
        return help(mp);
    }
    public int help(Map<Character,Integer> mp){
        int count = 0;
        for(char ch : mp.keySet()){
            int fre = mp.get(ch);
            if(fre>0) {
                mp.put(ch,fre-1);
                count += 1 + help(mp);
                mp.put(ch,fre);
            }
        }
        return count;
    }
}