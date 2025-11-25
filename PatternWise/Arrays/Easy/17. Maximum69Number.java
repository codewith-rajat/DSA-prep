// https://leetcode.com/problems/maximum-69-number/description/

class Solution {
    public int maximum69Number (int num) {
        int dig = 0;
        int x = num;
        while(x>0){
            dig++;
            x/=10;
        }
        int arr[] = new int[dig];
        for(int i=dig-1;i>=0;i--){
            int temp = num%10;
            arr[i] = temp;
            num/=10;
        }
        for(int i=0;i<dig;i++){
            if(arr[i]==6){
                arr[i] = 9;
                break;
            }
        }
        int ans = 0;
        for(int i:arr) ans = ans*10 + i;
        return ans;
    }
}