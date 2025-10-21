// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/description/

class Solution {
    public List<Integer> findLonely(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (freq.get(num) == 1 && 
                !freq.containsKey(num - 1) && 
                !freq.containsKey(num + 1)) {
                result.add(num);
            }
        }
        return result;
    }
}

class Solution {
    public List<Integer> findLonely(int[] nums) {
        int maxx = Arrays.stream(nums).max().getAsInt();
        int freq[] = new int[maxx+2];
        List<Integer> ls = new ArrayList<>();
        for(int i:nums) freq[i]++;
        for(int i=0;i<freq.length;i++){
            if(i>0 && i<freq.length-1){
                if(freq[i]==1 && freq[i-1]==0 && freq[i+1]==0) ls.add(i);
            }
            else if(i==0){
                if(freq[i]==1 && freq[i+1]==0) ls.add(i); 
            }
            else {
                if(freq[i]==1 && freq[i-1]==0) ls.add(i);
            }
        }
        return ls;
    }
}