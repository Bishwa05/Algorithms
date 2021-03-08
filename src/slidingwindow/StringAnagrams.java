package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string and a pattern, find all anagrams of the pattern in the given string.
 *
 * Input: String="ppqp", Pattern="pq"
 * Output: [1, 2]
 * Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
 *
 * Input: String="abbcabc", Pattern="abc"
 * Output: [2, 3, 4]
 * Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 *
 */
public class StringAnagrams
{
    public List<Integer> findStringAnagrams(String str, String pattern) {
        int windowStart =0, matched =0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for(char chr : pattern.toCharArray()){
            charFrequencyMap.put(chr, charFrequencyMap.getOrDefault(chr, 0)+1);
        }

        List<Integer> res = new ArrayList<>();

        for(int windowEnd =0; windowEnd< str.length(); windowEnd++){
            char rChar = str.charAt(windowEnd);

            if(charFrequencyMap.containsKey(rChar)){
                charFrequencyMap.put(rChar, charFrequencyMap.get(rChar)-1);
                if(charFrequencyMap.get(rChar)==0){
                    matched++;
                }
            }

            if(matched == charFrequencyMap.size()){
                res.add(windowStart);
            }

            if(windowEnd >= pattern.length()-1){
                char lChar = str.charAt(windowStart++);
                if(charFrequencyMap.containsKey(lChar)){
                    if(charFrequencyMap.get(lChar) == 0){
                        matched--;
                    }
                    charFrequencyMap.put(lChar, charFrequencyMap.get(lChar)+1);
                }
            }
        }
        return res;
    }
}
