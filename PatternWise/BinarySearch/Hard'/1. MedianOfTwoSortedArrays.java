// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// leetcode 4
import java.util.*;

public class MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int[] nums1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            nums1[i] = scanner.nextInt();
        }
        int n2 = scanner.nextInt();
        int[] nums2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            nums2[i] = scanner.nextInt();
        }
        MedianOfTwoSortedArrays motsa = new MedianOfTwoSortedArrays();
        double result = motsa.findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if (n > m) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int total = n + m;
        int l = 0, r = n;
        int partition = (total + 1) / 2;
        while(l<=r){
            int mid1 = l + (r-l)/2;
            int mid2 = partition - mid1;
            int l1 = mid1==0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int l2 = mid2==0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int r1 = mid1==n ? Integer.MAX_VALUE : nums1[mid1];
            int r2 = mid2==m ? Integer.MAX_VALUE : nums2[mid2];
            if(l1<=r2 && r1>=l2) {
                if(total%2==0) return (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                else return Math.max(l1,l2);
            }
            else if(l1>r2) r = mid1 - 1;
            else l = mid1 + 1;
        }
        return 0.0;
    }
}