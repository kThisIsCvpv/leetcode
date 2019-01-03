package hard.median_of_two_sorted_arrays;

import java.util.Arrays;

public class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] total = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, total, 0, nums1.length);
        System.arraycopy(nums2, 0, total, nums1.length, nums2.length);

        Arrays.sort(total);

        int index = total.length / 2;
        if (total.length % 2 == 1) {
            return total[(int) index];
        } else {
            return (total[index] + total[index - 1]) / 2.0;
        }
    }
}
