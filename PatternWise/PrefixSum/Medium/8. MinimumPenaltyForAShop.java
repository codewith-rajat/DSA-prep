// https://leetcode.com/problems/minimum-penalty-for-a-shop/description/?envType=daily-question&envId=2025-12-26

class Solution {
    public int bestClosingTime(String customers) {
        int pref[] = new int[customers.length()+1];
        for(int i=1;i<=customers.length();i++){
            int add = 0;
            if(customers.charAt(i-1)=='Y') add = 1;
            else add = -1;
            pref[i] = pref[i-1] + add; 
        }
        int idx = 0,max = 0;
        for(int i=0;i<pref.length;i++){
            if(pref[i]>max){
                max = pref[i];
                idx = i;
            }
        }
        return idx;
    }
}