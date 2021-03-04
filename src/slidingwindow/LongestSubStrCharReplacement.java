package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.
 *
 * Input: String="aabccbb", k=2
 * Output: 5
 * Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
 *
 */
public class LongestSubStrCharReplacement
{
    public int findLength(String str, int k){
       int windowStart =0, maxLenth =0, maxRepeatLetterCount =0;
       Map<Character, Integer> letterFrequencyMap = new HashMap<>();

       for(int windowEnd =0; windowEnd <str.length(); windowEnd++){
           char rightChar = str.charAt(windowEnd);
           letterFrequencyMap.put(rightChar, letterFrequencyMap.getOrDefault(rightChar, 0)+1);
           maxRepeatLetterCount = Math.max(maxRepeatLetterCount, letterFrequencyMap.get(rightChar));

           if(windowEnd - windowStart +1 - maxRepeatLetterCount > k){
               char leftChar = str.charAt(windowStart);
               letterFrequencyMap.put(leftChar, letterFrequencyMap.get(leftChar)-1);
               windowStart++;
           }
           maxLenth = Math.max(maxLenth, windowEnd-windowStart +1);
       }
    return maxLenth;
    }

    public static void main(String arg[]){
        LongestSubStrCharReplacement  f = new LongestSubStrCharReplacement();
        System.out.println(
            f.findLength("aabccbb", 2)
        );
    }
}
