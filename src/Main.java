import Easy.HaystackAndNeedle;
import Easy.LongestCommonPrefix;
import Easy.RomanToInteger;
import Easy.ValidParentheses;
import Sort.Sorting;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

    }

    private static void playSort() {
        int[] arr = new int[]{3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        Sorting.radixSort(arr);
        System.out.println("Radix Sort Result :");
        System.out.println(Arrays.toString(arr));

        Sorting.quickSort(arr);
        System.out.println("Quick Sort Result :");
        System.out.println(Arrays.toString(arr));

        Sorting.mergeSort(arr);
        System.out.println("Merge Sort Result :");
        System.out.println(Arrays.toString(arr));

        Sorting.insertionSort(arr);
        System.out.println("Insertion Sort Result :");
        System.out.println(Arrays.toString(arr));

        Sorting.selectionSort(arr);
        System.out.println("Selection Sort Result :");
        System.out.println(Arrays.toString(arr));

        Sorting.bubbleSort(arr);
        System.out.println("Bubble Sort Result :");
        System.out.println(Arrays.toString(arr));
    }

    private static void playHaystackAndNeedle() {
        HaystackAndNeedle haystackAndNeedle = new HaystackAndNeedle();
        System.out.println(haystackAndNeedle.strStr("mississippi", "sippia"));
    }

    public static void playRomanToInteger() {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }

    private static void playLongestCommonPrefix() {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] arr = {"c","c"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(arr));
    }

    private static void playValidParentheses() {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("([)]"));
    }
}
