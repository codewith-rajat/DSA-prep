// https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1

class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i] * (i+1)*(arr.length-i);
        }
        return sum;
    }
}
