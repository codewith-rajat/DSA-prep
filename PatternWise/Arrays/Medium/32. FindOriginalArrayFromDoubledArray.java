// https://leetcode.com/problems/find-original-array-from-doubled-array/description/
// leetcode2007
class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if(n%2==1) return new int[]{};
        Arrays.sort(changed);
        int freq[] = new int[100001];
        int ans[] = new int[n/2];
        int idx = 0;
        for(int i : changed) freq[i]++;
        for(int i : changed){
            if(freq[i]==0) continue;
            if(i==0) {
                if(freq[0]%2==1) return new int[]{};
                ans[idx++] = i;
                freq[0]-=2;
            }else{
                if(2*i>=freq.length || freq[2*i]==0) return new int[]{};
                ans[idx++] = i;
                freq[i]--;
                freq[2*i]--;
            }
        }
        return ans;
    }
}