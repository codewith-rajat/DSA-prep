// https://leetcode.com/problems/minimum-amount-of-time-to-collect-garbage/description/

class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int m = 0,p=0,g=0,mi=-1,pi=-1,gi=-1,time=0;
        for(int i=0;i<garbage.length;i++){
            String s = garbage[i];
            for(char ch:s.toCharArray()){
                if(ch=='M') {
                    m++;
                    mi = i;
                }
                else if(ch=='P') {
                    p++;
                    pi=i;
                }
                else {
                    g++;
                    gi=i;
                }
            }
        }
        for(int i=0;i<travel.length;i++){
            if(i<mi) time += travel[i];
            if(i<pi) time += travel[i];
            if(i<gi) time += travel[i];
        }
        return time + m + p + g;
    }
}