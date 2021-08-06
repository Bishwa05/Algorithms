package array;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 */

public class LongestSubstringWithoutRepeatingChar {

    public static int getNonRepCharLength(String str) {
        int maxChar = 0;

        int pointer1 =  0;
        int pointer2 = 0;

        Set<Character> charSet = new HashSet<>();

        for(; pointer2 <str.length();){
            if(!charSet.contains(str.charAt(pointer2))){
                charSet.add(str.charAt(pointer2));
                pointer2++;
                maxChar = Math.max(maxChar, charSet.size());

            } else {
                charSet.remove(str.charAt(pointer1));
                pointer1++;
            }
        }

        return maxChar;

    }


    public static void main(String arg[]) {
        String str = "pwwkew";
        System.out.println(getNonRepCharLength(str));
    }
}
