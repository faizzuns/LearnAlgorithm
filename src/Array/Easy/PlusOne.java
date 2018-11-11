package Array.Easy;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) return digits;
        else {
            int[] arrtemp = new int[digits.length + 1];
            int lastValue = digits[digits.length - 1];
            if (lastValue < 9) {
                digits[digits.length - 1]++;
                return digits;
            } else {
                int i = digits.length - 1;
                int add = 1;
                boolean increase = true;
                while (increase && i >= 0) {
                    digits[i] += add;
                    if (digits[i] >= 10) {
                        add = digits[i] / 10;
                        digits[i] %= 10;
                    } else {
                        increase = false;
                    }
                    arrtemp[i + 1] = digits[i];
                    i--;
                }
                if (increase) {
                    arrtemp[0] = add;
                    return arrtemp;
                } else return digits;
            }
        }
    }

    public void test() {
        int[] arr = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(plusOne(arr)));
    }
}
