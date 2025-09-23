// https://leetcode.com/problems/next-greater-element-i

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int next[] = new  int[10001];
        Stack<Integer> st = new Stack<>();
        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            next[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        for(int i=0;i<nums1.length;i++){
            nums1[i] = next[nums1[i]];
        }
        return nums1;
    }
}