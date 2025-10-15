// https://leetcode.com/problems/shifting-letters/

class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        int [] pref = new int[n];

        pref[n-1] = shifts[n-1]%26;
        for(int i=n-2;i>=0;i--){
            pref[i] = (pref[i+1] + shifts[i])%26;
        }
        char ch[] = s.toCharArray();
        for(int i=0;i<n;i++){
            int shift = ((s.charAt(i)-'a') + pref[i])%26;
            ch[i] = (char)(shift + 'a');
        }
        return new String(ch);
    }
}

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a0 = 1;
        int a1 = 1;
        if(n==1) System.out.println(1);
        int ans = 0;
        else{
            for(int i=2;i<=n;i++){
                ans = a0 + a1;
                a0 = a1;
                a1 = ans;
            }
            System.out.println(ans);
        }
    }
}