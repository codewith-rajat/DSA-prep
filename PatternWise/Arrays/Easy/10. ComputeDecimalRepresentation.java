// https://leetcode.com/contest/weekly-contest-469/problems/compute-decimal-representation/description/

class Solution {
    public int[] decimalRepresentation(int n) {
        List<Integer> ls = new ArrayList<>();
        int r = 0;
        while(n>0){
            int rem = n%10;
            if(rem!=0){
                int ad = (int)Math.pow(10,r) * rem;
                ls.add(ad);
            }
            n=n/10;
            r++;
        }
        int arr[] = new int[ls.size()];
        for(int i=0;i<arr.length;i++){
            arr[arr.length-i-1] = ls.get(i);
        }
        return arr;
    }
}