package backtrack;

import java.util.HashSet;
import java.util.Set;

/**
 * You have n  tiles, where each tile has one letter tiles[i] printed on it.
 *
 * Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.
 *
 *
 *
 * Example 1:
 *
 * Input: tiles = "AAB"
 * Output: 8
 * Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
 * Example 2:
 *
 * Input: tiles = "AAABBC"
 * Output: 188
 * Example 3:
 *
 * Input: tiles = "V"
 * Output: 1
 *
 */
public class LetterTilePossibilities
{
    private Set<String> set;
    private char[] chars;
    public int numTilePossibilities(String tiles) {

        int len = tiles.length();

        set = new HashSet<>();
        chars = tiles.toCharArray();

        for (int l = 1; l <= len; l++) {
            // Pick l numbers from nums, permutation
            dfs(new boolean[len], l, new StringBuilder());
        }

        for(String a : set){
            System.out.println(a);
        }
        return set.size();
    }

    private void dfs(boolean[] visited, int l, StringBuilder cur) {
        if (l == 0) {
            set.add(cur.toString());
        }

        for (int i = 0; i < chars.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                cur.append(chars[i]);
                dfs(visited, l - 1, cur);
                cur.deleteCharAt(cur.length() - 1);
                visited[i] = false;
            }
        }
    }


    public int numTilePossibilities2(String str) {
        int[] freq = new int[26];
        for (char ch : str.toCharArray()) {
            freq[ch - 'A']++;
        }

        return dfs(freq);
    }

    private int dfs(int[] freq) {
        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                count++;
                freq[i]--;
                count += dfs(freq);
                freq[i]++;
            }
        }

        return count;
    }

    public static void main(String arg[]){
        LetterTilePossibilities l = new LetterTilePossibilities();
        System.out.println(l.numTilePossibilities("AAABBC"));
    }
}
