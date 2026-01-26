// https://leetcode.com/problems/minimum-absolute-difference/description/?envType=daily-question&envId=2026-01-26
// leetcode1200class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE, n = arr.length;
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(arr);
        for(int i=1;i<n;i++){
            int curr = arr[i] - arr[i-1];
            min = Math.min(curr,min);
        }
        for(int i=1;i<n;i++){
            int curr = arr[i] - arr[i-1];
            if(curr==min) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ls.add(temp);
            }
        }
        return ls;
    }
}