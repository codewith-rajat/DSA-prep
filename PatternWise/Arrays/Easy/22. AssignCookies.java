// https://leetcode.com/problems/assign-cookies/description/
// leetcode 455
import java.util.*;
public class AssignCookies {
    public static void main(String args[]){
        int[] g = {1,2,3};
        int[] s = {1,1};
        AssignCookies ac = new AssignCookies();
        int result = ac.findContentChildren(g, s);
        System.out.println(result);
    }
    public int findContentChildren(int[] g, int[] s) {
        int ans = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0, j=0, n=g.length,m=s.length;
        while(i<n && j<m){
            if(s[j]>=g[i]){
                ans++;
                i++;
            }
            j++;
        }
        return ans;
    }
}