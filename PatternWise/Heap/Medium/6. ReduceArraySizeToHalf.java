// https://leetcode.com/problems/reduce-array-size-to-the-half/description/

class Solution {
    public int minSetSize(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        int maxx = Arrays.stream(arr).max().getAsInt();
        int freq[] = new int[maxx+1];
        for(int i:arr) freq[i]++;
        for(int i=0;i<freq.length;i++) pq.add(new int[]{i,freq[i]});
        int c = 0;
        int ans = 0;
        while(c<arr.length/2){
            int curr[] = pq.poll();
            int f = curr[1];
            c+=f;
            ans++;
        }
        return ans;
    }
} 