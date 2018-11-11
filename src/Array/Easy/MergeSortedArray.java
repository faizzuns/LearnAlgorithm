package Array.Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        int left = 0;
        int right = m - 1 < 0 ? 0 : m - 1;
        int middle = (left + right) / 2;
        int indexSecondArray = 0;
        while (indexSecondArray < n) {
//            System.out.println(left + " " + right  + " " + middle  + " " + indexSecondArray);
            if (left == right) {
                int start = nums2[indexSecondArray] < nums1[left] ? left : left + 1;
                int stop = (m - 1) + (indexSecondArray + 1);
                insert(start , nums1, nums2[indexSecondArray], stop);
                indexSecondArray++;
                left = start;
                right = stop;
            } else {
                if (nums2[indexSecondArray] > nums1[middle]) left = middle + 1;
                else if (nums2[indexSecondArray] < nums1[middle]) right = middle - 1;
                else {
                    int stop = (m - 1) + (indexSecondArray + 1);
                    insert(middle, nums1, nums2[indexSecondArray], stop);
                    indexSecondArray++;
                    left = middle;
                    right = stop;
                }
            }
            right = right < 0 ? 0 : right;
            if (left > right) {
                left = right;
            }
            middle = (left + right) / 2;

//            System.out.println(left + " " + right  + " " + middle  + " " + indexSecondArray);
//            System.out.println();
        }
    }

    public void insert(int idx, int[] num, int val, int m) {
//        System.out.println("INSERT " + val + " in index " + idx + " at array " + Arrays.toString(num) + " and stop at " + m);
        for (int i = m; i > idx; i--) {
            num[i] = num[i - 1];
        }
        num[idx] = val;
    }

    public void test() {
        int[] nums1 = new int[] {0,1,2,3,0,0,0,0,0};
        int[] nums2 = new int[] {-1,1,2,3,7};
        merge(nums1, 4, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }
}
