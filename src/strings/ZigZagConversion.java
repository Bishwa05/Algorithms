package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * Create as many entries in hashmap as no of rows.
 * The zigzag order is maintained by 2 counters here pos and increment.
 */

public class ZigZagConversion {

    public static String findZigZagString(String str, int numRows) {
        Map<Integer, StringBuilder> map = new HashMap<>();
        int pos = 0;
        boolean increment = true;
        for(char c : str.toCharArray()) {
            if (pos == numRows) increment = false;
            if (pos == 1) increment = true;
            if (increment)
                pos++;
            else
                pos--;

            if (!map.containsKey(pos))
                map.put(pos, new StringBuilder());
            map.get(pos).append(c);
        }

        StringBuilder res = new StringBuilder();
        for(int i : map.keySet()){
            res.append(map.get(i));
        }
        return res.toString();
    }

    public static void main(String arg[]) {
        String str ="PAYPALISHIRING";
        int num =4;
        System.out.println(findZigZagString(str, num));
    }
}
