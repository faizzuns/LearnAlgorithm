package Array.Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 */
public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0 ; i < numRows; i++) {
            List<Integer> li = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == (i)) {
                    li.add(1);
                } else {
                    int left = list.get(i - 1).get(j - 1);
                    int right = list.get(i - 1).get(j);
                    li.add(left + right);
                }
            }
            list.add(li);
        }
        return list;
    }

    public void test() {
        List<List<Integer>> list = generate(5);
        System.out.println(list.toString());
    }
}
