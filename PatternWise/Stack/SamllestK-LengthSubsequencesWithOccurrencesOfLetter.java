// https://leetcode.com/problems/smallest-k-length-subsequence-with-occurrences-of-a-letter/description/
// leetcode 2030
import java.util.*;
public class Main {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in); 
        String s = sc.next();
        int k = sc.nextInt();
        char letter = sc.next();
        int repetition = sc.nextInt();
        Main obj = new Main();
        System.out.println(obj.smallestSubsequence(s, k, letter, repetition));
    }
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        Stack<Character> st = new Stack<>();
        int c = 0, n = s.length();
        for(char ch : s.toCharArray()) if(ch==letter) c++;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && st.peek()>s.charAt(i) && k-st.size()<n-i){
                if(st.peek()!=letter) st.pop();
                else {
                    if(c>repetition) {
                        st.pop();
                        repetition++;
                    }
                    else break;
                }
            }
            if(st.size()<k){
                if(s.charAt(i)==letter) {
                    st.push(s.charAt(i));
                    repetition--;
                }
                else {
                    if(k-st.size()>repetition) st.push(s.charAt(i));
                }
            }
            if(s.charAt(i)==letter) c--;
        }
        StringBuilder sb = new StringBuilder();
        while(st.size()>0) sb.append(st.pop());
        return sb.reverse().toString();
    }
}