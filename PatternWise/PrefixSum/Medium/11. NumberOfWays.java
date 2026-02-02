// https://codeforces.com/problemset/problem/466/C
// cf div2

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long arr[] = new long[n];
        long sum = 0;
        for(int i=0;i<n;i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        if(sum%3!=0 || n<3) {
            System.out.println(0);
            return;
        }
        long target = sum/3, pref = 0;
        long ways = 0, count = 0;
        for(int i=0;i<n-1;i++){
            pref += arr[i];
            if(pref==2*target) ways += count;
            if(pref==target) count++;
        }
        System.out.println(ways);
    }
}