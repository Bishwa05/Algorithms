package backtrack;

import java.util.List;

/**
 *1239. Maximum Length of a Concatenated String with Unique Characters
 *
 *
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 *
 * Return the maximum possible length of s.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 *
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 *
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 */
public class MaximumLengthConcatenatedStringWithUniqueCharacters
{

    public int maxLength(List<String> arr) {

        return backtrack(arr, 0, "");

    }

    public int backtrack(List<String> arr, int index, String current) {

        if (index == arr.size()) {
            if (isAllUnique(current))
                return current.length();
            return -1;
        }

        return Math.max(backtrack(arr, index + 1, current),
            backtrack(arr, index + 1, current + arr.get(index)));

    }

    boolean isAllUnique(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            if (arr[c - 'a'] > 0)
                return false;
            arr[c - 'a'] = arr[c - 'a'] + 1;
        }
        return true;
    }

}
