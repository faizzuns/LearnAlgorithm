package Sort;

import java.util.ArrayList;
import java.util.List;

public class Sorting {

    private static void swapElement(int[] arr, int firstIdx, int secondIdx) {
        int temp = arr[firstIdx];
        arr[firstIdx] = arr[secondIdx];
        arr[secondIdx] = temp;
    }

    /**
     * Worst case = O(n*n), when array is reverse sorted
     * Best Case = O(n), when array already sorted
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        int i = arr.length - 1;
        boolean swap;
        while (i > 0) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElement(arr, j, j + 1);
                    swap = true;
                }
            }
            i--;
            //break if there is no two element swapped
            if (!swap) break;
        }
    }

    /**
     * Worst Case & Best Case = O(n*n)
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        int i = 0;
        while (i < arr.length - 1) {
            int swappedIdx = i;
            for (int j = i + 1; j < arr.length; j++ ) {
                if (arr[j] < arr[swappedIdx]) {
                    swappedIdx = j;
                }
            }
            swapElement(arr, i, swappedIdx);
            i++;
        }
    }

    /**
     * Worst case = O(n*n), when array reverse sorted
     * Best case = O(n), when array already sorted
     * @param arr
     */
    public static void insertionSort(int[] arr) {
        int i = 1;
        while (i < arr.length) {
            int pointer = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[pointer] < arr[j]) {
                    swapElement(arr, pointer, j);
                    pointer = j;
                } else {
                    break;
                }
            }
            i++;
        }
    }

    /**
     * Worst case, best case = O(n log n), because always divide and merge elements
     * @param arr
     */
    public static void mergeSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        mergeSort(arr, left, right);
    }
    private static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle + 1, right);
            merge(arr, left, middle, right);
        }
    }
    private static void merge(int[] arr, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

//        temp arr
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for (int i = 0; i < n1; i++) {
            arr1[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            arr2[i] = arr[middle + i + 1];
        }

        int i = 0;
        int j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (arr1[i] < arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (k < right + 1) {
            if (i == n1) {
                arr[k] = arr2[j];
                j++;
            } else if (j == n2) {
                arr[k] = arr1[i];
                i++;
            }
            k++;
        }

    }

    /**
     * Worst Case : O(n*n), when pivot always selected greatest/smallest
     * Best Case : O(n log n), when pivot always select middle element
     * @param arr
     */
    public static void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        quickSort(arr, left, right);
    }
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = left;
            for (int i = left + 1; i <= right; i++) {
                if (arr[i] < arr[left]) {
                    pivot++;
                    if (pivot != i) swapElement(arr, i, pivot);
                }
            }
            if (pivot != left) swapElement(arr, pivot, left);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static void radixSort(int[] arr) {
        List<List<Integer>> bucket = new ArrayList<List<Integer>>();
        for (int i = 0; i < 10; i++) bucket.add(new ArrayList<Integer>());
        int maxValue = getMax(arr);
        for (int i = 1; maxValue / i != 0; i *= 10) {
            for (int item : arr) {
                int val = (item/ i) % 10;
                bucket.get(val).add(item);
            }
            int key = 0;
            for (int j = 0; j < arr.length; j++) {
                while (bucket.get(key).size() == 0) {
                    key++;
                }
                arr[j] = bucket.get(key).remove(0);
            }
        }
    }
    private static int getMax(int[] arr) {
        int val = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == 0) val = arr[i];
            if (arr[i] > val) {
                val = arr[i];
            }
        }
        return val;
    }
}
