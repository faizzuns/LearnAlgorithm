import Easy.*;
import Sort.Sorting;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("0100");
        list1.add("1001");
        list1.add("0011");
        list1.add("0011");
        List<String> list2 = new ArrayList<String>();
        list2.add("0101");
        list2.add("1001");
        list2.add("0011");
        list2.add("0011");
        System.out.println(countMatches(list1, list2));
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + "," + y + ")";
        }
    }

    public static int countMatches(List<String> grid1, List<String> grid2) {
        // Write your code here
        boolean[][] flags = new boolean[grid1.size()][grid1.size()];
        int n = grid1.size();
        List<Point> listPoint = new ArrayList<Point>();
        List<Point> listAllPoint = new ArrayList<Point>();
        List<Point> listAdj = new ArrayList<Point>();

        for (int i = 0; i < grid1.size() * grid1.size(); i++) {
            Point p = new Point(i / n, i % n);
            if (grid1.get(i / n).charAt(i % n) == grid2.get(i / n).charAt(i % n)) {
                if (grid1.get(i / n).charAt(i % n) == '1') {
                    flags[i / n][i % n] = true;
                    listPoint.add(p);
                } else {
                    flags[i / n][i % n] = false;
                }
            } else {
                flags[i / n][i % n] = true;
                listPoint.add(p);
                listAdj.add(p);
            }
            listAllPoint.add(p);
        }

        int count = 0;
        for (Point pp : listPoint) {
            if (flags[pp.getX()][pp.getY()]) {
                boolean check = bfs(flags, listAllPoint, listAdj, pp);
                if (check) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean bfs(boolean[][] flags, List<Point> listPoint, List<Point> listAdj, Point p) {
        if (!flags[p.getX()][p.getY()]) {
            return true;
        }
        flags[p.getX()][p.getY()] = false;
        boolean res = !listAdj.contains(p);

        for (int i = 0; i < 4; i++) {
            int x = i < 2 ? p.getX() : i == 2 ? p.getX() - 1 : p.getX() + 1;
            int y = i > 1 ? p.getY() : i == 0 ? p.getY() - 1 : p.getY() + 1;
            if (x >= 0 && x < flags.length && y >= 0 && y < flags.length) {
                res = bfs(flags, listPoint, listAdj, listPoint.get(x * flags.length + y)) && res;
            }
        }
        return res;
    }

    public static int getIndex(String direction) {
        int result;
        if (direction.equals("LEFT")) result = 0;
        else if (direction.equals("RIGHT")) result = 1;
        else if (direction.equals("UP")) result = 2;
        else result = 3;
        return result;
    }

    public static int roverMove(int matrixSize, List<String> cmds) {
        int[] directionArr = new int[]{-1, 1, matrixSize * (-1), matrixSize};
        int pos = 0;
        for (String direction : cmds) {
            int idx = getIndex(direction);
            int temp = pos + directionArr[idx];
            if (temp >= 0 && temp < matrixSize * matrixSize) {
                if (idx >= 2) {
                    pos += directionArr[idx];
                } else {
                    if (pos / matrixSize == temp / matrixSize) {
                        pos += directionArr[idx];
                    }
                }
            }
        }
        return pos;
    }

    public static List<Integer> closest(String s, List<Integer> queries) {
        // Write your code here
        HashMap<Character, List<Integer>> map = new HashMap<Character, List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) map.put(c, new ArrayList<Integer>());
            map.get(c).add(i);
        }

        List<Integer> result = new ArrayList<Integer>();
        for (int q : queries) {
            int ans = -1;
            List<Integer> li = map.get(s.charAt(q));
            if (li.size() > 1) {
                int left = 0;
                int right = li.size() - 1;
                int middle = (left + right) / 2;
                while (left < right) {
                    if (q > li.get(middle)) {
                        left = middle + 1;
                        middle = (left + right) / 2;
                    } else if (q < li.get(middle)) {
                        right = middle - 1;
                        middle = (left + right) / 2;
                    } else {
                        left = right;
                    }
                }
                if (middle == 0) ans = li.get(middle + 1);
                else if (middle == li.size() - 1) ans = li.get(middle - 1);
                else {
                    System.out.println(Math.abs(q - li.get(middle - 1)));
                    System.out.println(Math.abs(q - li.get(middle + 1)));
                    System.out.println();
                    ans = Math.abs(q - li.get(middle - 1)) <= Math.abs(q - li.get(middle + 1)) ? li.get(middle - 1) : li.get(middle + 1);
                }
            }
            result.add(ans);
        }
        return result;
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
