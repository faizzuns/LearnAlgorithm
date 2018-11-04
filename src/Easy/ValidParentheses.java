package Easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @link https://leetcode.com/problems/valid-parentheses/description/
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        int len = s.length();
        Stack<Character> stack = new Stack<Character>();
        HashSet<Character> set = new HashSet<Character>();
        set.add('('); set.add('{'); set.add('[');
        HashMap<Character, Character> mapPair = new HashMap<Character, Character>();
        mapPair.put(')', '(');
        mapPair.put('}', '{');
        mapPair.put(']', '[');
        if (len % 2 == 1) {
            return false;
        } else {
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    stack.push(c);
                } else {
                    char op = mapPair.get(c);
                    if (stack.isEmpty() || op != stack.pop()) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
