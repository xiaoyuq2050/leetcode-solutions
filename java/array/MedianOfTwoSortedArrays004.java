package array;

public class MedianOfTwoSortedArrays004 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{3,5,8,9}, new int[]{1,2,7,10,11,12}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        int length = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        while (cut1 <= nums1.length) {
            cut1 = cutL + (cutR - cutL) / 2;
            cut2 = length / 2 - cut1;
            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int R1 = (cut1 == nums1.length) ? Integer.MAX_VALUE : nums1[cut1];
            int R2 = (cut2 == nums2.length) ? Integer.MAX_VALUE : nums2[cut2];
            if (L1 > R2) {
                cutR = cut1 - 1;
            }
            if (L2 > R1) {
                cutL = cut1 + 1;
            }
            if (L1 <= R2 && L2 <= R1) {
                if (length % 2 == 0) {
                    int median_left = (L1 > L2) ? L1 : L2;
                    int median_right = (R1 > R2) ? R2 : R1;
                    return (double) (median_left + median_right) / 2;
                } else {
                    return (R1 > R2) ? R2 : R1;
                }
            }
        }
        return -1;
    }
}
