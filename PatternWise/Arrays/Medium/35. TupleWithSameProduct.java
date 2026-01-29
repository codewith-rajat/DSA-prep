// https://leetcode.com/problems/tuple-with-same-product/description/
// leetcode 1726

class Solution {
    public int tupleSameProduct(int[] nums) {
        HashMap<Integer,Integer> res = new HashMap<>();
        int product = 1;
        int result =0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                product = nums[i]*nums[j];
                result += 8 * res.getOrDefault(product,0);
                res.put(product,res.getOrDefault(product,0)+1);
            }
        }
        return result;
    }
}