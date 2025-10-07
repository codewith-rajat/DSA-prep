class Solution {
    public int climbStairs(int n) {
        int arr[] = new int[n+1];
        Arrays.fill(arr,-1);
        int ans = fibo(n,arr);
        return ans;
    }
    public int fibo(int n,int[] arr){
        if(n==1 || n==0) return n;
        if(arr[n]!=-1) return arr[n];
        arr[n] = fibo(n-1,arr) + fibo(n-2,arr);
        return arr[n];
    }
}