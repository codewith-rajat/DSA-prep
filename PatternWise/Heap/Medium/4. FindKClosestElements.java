// https://leetcode.com/problems/find-k-closest-elements/description/  26-8-25

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]
        );
        for(int ele : arr){
            int dist = Math.abs(x-ele);
            pq.add(new int[]{dist,ele});
            if(pq.size()>k) pq.poll();
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<k;i++){
            ans.add(pq.poll()[1]);
        }
        Collections.sort(ans);
        return ans;
    }
}


// https://www.geeksforgeeks.org/problems/k-closest-elements3619/1

class Solution {
    int[] printKClosest(int[] arr, int k, int x) {
        // code here
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0] == a[0] ? a[1] - b[1] : b[0] - a[0]
        );
        for(int ele : arr){
            if(ele==x) continue;
            int dist = Math.abs(ele-x);
            pq.add(new int[]{dist,ele});
            if(pq.size()>k) pq.poll();
        }
        int ans[] = new int[k];
        for(int i = k-1;i>=0;i--){
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}