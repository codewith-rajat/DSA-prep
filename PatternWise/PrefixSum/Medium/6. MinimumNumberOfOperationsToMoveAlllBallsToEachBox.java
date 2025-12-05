// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int ans[] = new int[n];
        int prefCount = 0, prefSum = 0;
        for(int i=0;i<n;i++){
              ans[i] = prefCount*i - prefSum;
              if(boxes.charAt(i)=='1'){
                prefCount++;
                prefSum += i;
              }
        }
        int sufCount = 0, sufSum = 0;
        for(int i=n-1;i>=0;i--){
            ans[i] += sufSum - sufCount*i;
            if(boxes.charAt(i)=='1'){
                sufCount++;
                sufSum += i;
            }
        }
        return ans;
    }
}