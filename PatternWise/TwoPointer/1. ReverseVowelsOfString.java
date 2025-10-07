// https://leetcode.com/problems/reverse-vowels-of-a-string/

class Solution {
    public boolean isVowel(char ch){
        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U') return true;
        return false;
    }
    public String reverseVowels(String s) {
        int i=0;
        int j = s.length()-1;
        char arr[] = new char[s.length()];
        while(i<=j){
            if(!isVowel(s.charAt(i))) {
                arr[i] = s.charAt(i);
                i++;
            }
            else if(!isVowel(s.charAt(j))) {
                arr[j] = s.charAt(j);
                j--;
            }
            else{
                arr[j] = s.charAt(i);
                arr[i] = s.charAt(j);
                i++;
                j--;
            } 
        }
    return new String(arr);
    }
}