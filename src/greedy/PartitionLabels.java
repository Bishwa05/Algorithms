package greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
 *
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
 *
 */
public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int[] lastOcc = new int[26];
        // Store the last occurance of each character
        for (int i = 0; i < s.length(); i++) {
            lastOcc[s.charAt(i)-'a'] = i;
        }

        int partitionStart = 0, partitionEnd = 0;
        List<Integer> result = new ArrayList<>();
        // Iterate through string to determine partition
        for(int i = 0; i < s.length(); i++) {
            partitionEnd = Math.max(partitionEnd, lastOcc[s.charAt(i) - 'a']);
            // When we reach end of current partition
            if (i == partitionEnd) {
                result.add(partitionEnd - partitionStart + 1);
                partitionStart = i+1; // Move to next partition
            }
        }
        return result;
    }
}
