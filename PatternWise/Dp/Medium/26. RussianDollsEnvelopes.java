// https://leetcode.com/problems/russian-doll-envelopes/description/

class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = envelopes.length;
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = envelopes[i][1];
        }
        return lengthOfLIS(heights);
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            int i = Collections.binarySearch(temp, num);
            if (i < 0) i = -(i + 1);
            if (i == temp.size()) temp.add(num);
            else temp.set(i, num);
        }
        return temp.size();
    }
}
