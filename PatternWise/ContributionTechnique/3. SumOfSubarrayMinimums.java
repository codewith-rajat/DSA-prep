// https://leetcode.com/problems/sum-of-subarray-minimums/
// leetcode 907
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int ple[] = new int[n];
        int nle[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long sum = 0;
        for(int i=0;i<n;i++){
            long left = i - ple[i];
            long right = nle[i] - i;
            long contribution = (arr[i] * left * right) % (int)(1000000007);
            sum = (sum + contribution) % (int)(1000000007);
        }
        return (int)sum;
    }
}