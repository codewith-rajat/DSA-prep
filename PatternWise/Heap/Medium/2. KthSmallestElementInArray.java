// https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1 25-8-25

class Solution {
    public static int kthSmallest(int[] arr, int k) {
        // Your code here
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);
            if(pq.size()>k) pq.poll();
        }
        return pq.poll();
    }
}
