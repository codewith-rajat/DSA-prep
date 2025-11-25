// https://leetcode.com/problems/pancake-sorting/description/

class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ls = new ArrayList<>();
        for(int i=arr.length-1;i>0;i--){
            int maxi = 0;
            for(int j=1;j<=i;j++){
                if(arr[j]>arr[maxi]) maxi = j;
            }
            if(maxi!=0){
                reverse(arr,0,maxi);
                ls.add(maxi+1);
            }
            reverse(arr,0,i);
            ls.add(i+1);
        }
        return ls;
    }
    public void reverse(int []arr, int l,int r){
        while(l<r){
            int temp = arr[r];
            arr[r] = arr[l];
            arr[l] = temp;
            l++;
            r--;
        }
    }
}