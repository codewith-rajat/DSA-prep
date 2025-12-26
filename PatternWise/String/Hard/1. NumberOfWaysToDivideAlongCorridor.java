// https://leetcode.com/problems/number-of-ways-to-divide-a-long-corridor/?envType=daily-question&envId=2025-12-14

class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1000000007;
        long res = 1;
        int seats = 0;
        int plants = 0;

        for (char ch : corridor.toCharArray()) {
            if (ch == 'S') {
                seats++;
                if (seats > 2 && seats % 2 == 1) {
                    res = (res * (plants + 1)) % MOD;
                    plants = 0;
                }
            } else if (seats % 2 == 0 && seats > 0) {
                plants++;
            }
        }

        return (seats == 0 || seats % 2 == 1) ? 0 : (int) res;
    }
}


class Solution {
    public int numberOfWays(String corridor) {
        int count=0;
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<corridor.length();i++){
            char ch = corridor.charAt(i);
            if(ch=='S'){
                count++;
                ls.add(i);
            }
        }
        if(count==2) return 1;
        if(count==0 || count%2==1) return 0;
        long res = 1;
        for(int i=2;i<ls.size();i+=2){
            int gap = ls.get(i) - ls.get(i-1);
            res = (res*gap)%(1000000007);
        }
        return (int)res;
    }
}