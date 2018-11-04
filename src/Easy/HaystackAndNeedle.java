package Easy;

/**
 * @link https://leetcode.com/problems/implement-strstr/description/
 */
public class HaystackAndNeedle {
    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        } else if (needle.length() == 0) {
            return 0;
        }

        int last_index = haystack.length() - needle.length();
        for (int index = 0; index <= last_index; index++) {
            char c = haystack.charAt(index);
            if (c == needle.charAt(0)) {
                int finishIndex = index + needle.length();
                String compare = haystack.substring(index, finishIndex);
                if (needle.equals(compare)) {
                    return index;
                }
            }
        }
        return -1;
    }
}
