// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
// leetcode 28
import java.util.*;
class FindIndexOfFirstOccurrenceOfAString {
    public static void main(String[] args) {
        FindIndexOfFirstOccurrenceOfAString sol = new FindIndexOfFirstOccurrenceOfAString();
        Scanner sc = new Scanner(System.in);
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        System.out.println(sol.strStr(haystack, needle)); // Output: index of first occurrence
    }
    public int strStr(String haystack, String needle) {
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i)==needle.charAt(0)){
                if(solve(haystack,needle,i)) return i;
            }
        }
        return -1;
    }
    public boolean solve(String haystack, String needle, int i){
        int j=0, n=needle.length();
        int c = 0;
        while(j<n && i<haystack.length()){
            if(needle.charAt(j)==haystack.charAt(i)){
                c++;
            }
            i++;
            j++;
        }
        return c==needle.length();
    }
}