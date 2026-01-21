// https://leetcode.com/problems/power-of-heroes/description/
// leetcode2681
import java.util.*;
public class PowerOfHeroes{
    public static void main(String[] args) {
        PowerOfHeroes sol = new PowerOfHeroes();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] powers = new int[n];
        for (int i = 0; i < n; i++) {
            powers[i] = sc.nextInt();
        }
        System.out.println(sol.sumOfPower(powers)); // Output: maximum power
    }
    static final long MOD = 1_000_000_007;
    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        long prefixsum = 0, result = 0;
        for(int num : nums){
            long numsquared = (long) num * num % MOD;
            result = (result + numsquared * (prefixsum + num) % MOD) % MOD;
            prefixsum = (prefixsum * 2 + num) % MOD;
        }
        return (int)result;
    }
}