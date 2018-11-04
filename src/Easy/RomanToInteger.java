package Easy;

import java.util.HashMap;


/**
 * @link https://leetcode.com/problems/roman-to-integer/description/
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = getRomanianIntegerPair();
        int len = s.length();
        if (len == 0) {
            return -1;
        }
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; i--) {
            int value = map.get(s.charAt(i));
            int nextValue = map.get(s.charAt(i + 1));
            if (value < nextValue) {
                sum -= value;
            } else {
                sum += value;
            }
        }
        return sum;
    }

    private HashMap<Character, Integer> getRomanianIntegerPair() {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        return map;
    }

}
