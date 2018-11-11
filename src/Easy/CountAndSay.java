package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/count-and-say
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            List<Character> list = new ArrayList<Character>();
            String temp = "";
            for (char item : result.toCharArray()) {
                if (list.size() != 0) {
                    if (item != list.get(0)) {
                        temp += String.valueOf(list.size());
                        temp += String.valueOf(list.get(0));
                        list.size();
                        list.subList(0, list.size()).clear();
                    }
                }
                list.add(item);
            }
            temp += String.valueOf(list.size());
            temp += String.valueOf(list.get(0));
            result = temp;
        }
        return result;
    }
}
