// https://leetcode.com/problems/maximum-subarray-min-product/description/
// leetcode 1856
class Solution {
    static final int MOD = 1_000_000_007;
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int ple[] = new int[n];
        int nle[] = new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]) st.pop();
            ple[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) st.pop();
            nle[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long pref[] = new long[n];
        pref[0] = nums[0];
        for(int i=1;i<n;i++){
            pref[i] = pref[i-1] + nums[i];
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            int left = ple[i] + 1;
            int right = nle[i] - 1;
            long sum = pref[right] - (left>0 ? pref[left-1] : 0);
            long product = sum * nums[i];
            ans = Math.max(ans,product);
        }
        return (int)(ans % MOD);
    }
}   