// https://leetcode.com/problems/rearrange-words-in-a-sentence/description/

class Solution {
    public String arrangeWords(String text) {
        StringBuilder sb = new StringBuilder();
        String []temp = text.toLowerCase().split(" ");
        Arrays.sort(temp,(a,b)->a.length()-b.length());
        sb.append(temp[0].substring(0,1).toUpperCase() + temp[0].substring(1));
        for(int i=1;i<temp.length;i++){
            sb.append(' ').append(temp[i]);
        }
        return sb.toString();
    }
}