// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1

class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        // write code here
        List<Integer> ls = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++) if(arr[i]<0) ls.add(i);
        int l = 0,r = 0, start = 0, n = arr.length;
        while(r<n){
            if(r-l+1<k){
                r++;
                continue;
            }
            while(start<ls.size() && ls.get(start)<l) start++;
            if(start<ls.size() && ls.get(start)<=r) res.add(arr[ls.get(start)]);
            else res.add(0);
            l++;
            r++;
        }
        return res;
    }
}