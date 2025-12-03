// https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/

class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int ans = 0, sum = 0;
        for(int i=0;i<k;i++) sum += arr[i];
        int avg = sum/k;
        if(avg>=threshold) ans++;
        for(int i=k;i<arr.length;i++){
            sum += arr[i] - arr[i-k];
            avg = sum/k;
            if(avg>=threshold) ans++;
        }
        return ans;
    }
}