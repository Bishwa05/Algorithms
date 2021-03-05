package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: String="araaci", K=2
 * Output: 4
 * Explanation: The longest substring with no more than '2' distinct characters is "araa".
 *
 * Input: String="araaci", K=1
 * Output: 2
 * Explanation: The longest substring with no more than '1' distinct characters is "aa".
 *
 *
 * Input: String="cbbebi", K=3
 * Output: 5
 * Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 *
 *
 */
public class LongestSubStringWithKDistinctCharacters
{
    public int findLength(String str, int k){
        if(str == null || str.length() == 0 || str.length()  <k){
            return -1;
        }

        int windowStart = 0, maxLen = 0;

        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        for(int windowEnd = 0; windowEnd<str.length(); windowEnd++){
            char rChar = str.charAt(windowEnd);
            charFrequencyMap.put(rChar, charFrequencyMap.getOrDefault(rChar, 0)+1);
            while(charFrequencyMap.size()> k){
                char lChar = str.charAt(windowStart);
                charFrequencyMap.put(lChar, charFrequencyMap.get(lChar)-1);
                if(charFrequencyMap.get(lChar) == 0){
                    charFrequencyMap.remove(lChar);
                }
                windowStart++;
            }
            maxLen = Math.max(maxLen, windowEnd-windowStart+1);
        }
        return maxLen;
    }

    public static void main(String arg[]){
        LongestSubStringWithKDistinctCharacters  l = new LongestSubStringWithKDistinctCharacters();
        System.out.println(
            l.findLength("cbbebi", 3)
        );
    }
}
