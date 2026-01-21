// https://leetcode.com/problems/subarrays-with-k-different-integers/description/

// leetcode 992
import java.util.*;
public class SubarrayWithKDistinctIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        SubarrayWithKDistinctIntegers sol = new SubarrayWithKDistinctIntegers();
        int result = sol.subarraysWithKDistinct(nums, k);
        System.out.println(result);
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int ans = 0, i = 0, j = 0, prefix = 0, n = nums.length;
        while(j<n){
            mp.put(nums[j],mp.getOrDefault(nums[j],0)+1);
            if(mp.size()>k) {
                while(mp.size()>k){
                    mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                    if(mp.get(nums[i])==0) mp.remove(nums[i]);
                    i++;
                }
                prefix = 0;
            }
            while(mp.size()==k && mp.get(nums[i])>1){
                mp.put(nums[i],mp.getOrDefault(nums[i],0)-1);
                i++;
                prefix++;
            }
            if(mp.size()==k) ans += prefix + 1;
            j++;
        }
        return ans;
    }
}

// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         return atMostK(nums, k) - atMostK(nums, k - 1);
//     }

//     private int atMostK(int[] nums, int k) {
//         Map<Integer, Integer> map = new HashMap<>();
//         int i = 0, ans = 0;

//         for (int j = 0; j < nums.length; j++) {
//             map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

//             while (map.size() > k) {
//                 map.put(nums[i], map.get(nums[i]) - 1);
//                 if (map.get(nums[i]) == 0) {
//                     map.remove(nums[i]);
//                 }
//                 i++;
//             }

//             ans += j - i + 1;
//         }

//         return ans;
//     }
// }
