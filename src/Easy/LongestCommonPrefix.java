package Easy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @link https://leetcode.com/problems/longest-common-prefix/description/
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        boolean iterate = true;
        int len = strs.length;
        if (len == 0) {
            return "";
        }
        String firstString = strs[0];
        int finish = firstString.length() - 1;
        for (int i = 1; i < len; i++) {
            String s = strs[i];
            int j = 0;
            int pointer = -1;
            boolean check = true;
            while (check && j < s.length() && j <= finish) {
                if (firstString.charAt(j) == s.charAt(j)) {
                    pointer++;
                    j++;
                } else {
                    check = false;
                }
            }
            finish = pointer;
        }

        String result = "";
        for (int i = 0; i <= finish; i++) {
            result += firstString.charAt(i);
        }

        return result;
    }
}
