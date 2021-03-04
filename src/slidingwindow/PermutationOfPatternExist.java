package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern.
 *
 *
 * Time complexity : O(N+M) where N and M are number of character in input string and pattern.
 */
public class PermutationOfPatternExist
{
    public boolean findPermutation(String str, String pattern){
        int windowStart =0, matched =0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(char c: pattern.toCharArray()){
            charFrequencyMap.put(c, charFrequencyMap.getOrDefault(c, 0)+1);
        }

        for(int windowEnd = 0; windowEnd< str.length(); windowEnd++){
            char rChar = str.charAt(windowEnd);
            if(charFrequencyMap.containsKey(rChar)){
                charFrequencyMap.put(rChar, charFrequencyMap.get(rChar)-1);
                if(charFrequencyMap.get(rChar)==0){
                    matched++;
                }
            }

            if(matched == charFrequencyMap.size()){
                return true;
            }

            if(windowEnd >= pattern.length() -1){
                char lChar = str.charAt(windowStart++);
                if(charFrequencyMap.containsKey(lChar)){
                    if(charFrequencyMap.get(lChar)==0){
                        matched--;
                    }
                    charFrequencyMap.put(lChar, charFrequencyMap.get(lChar)+1);
                }
            }
        }
        return false;
    }
}
