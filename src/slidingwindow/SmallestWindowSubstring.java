package slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: String="aabdec", Pattern="abc"
 * Output: "abdec"
 * Explanation: The smallest substring having all characters of the pattern is "abdec"
 *
 * Input: String="abdabca", Pattern="abc"
 * Output: "abc"
 * Explanation: The smallest substring having all characters of the pattern is "abc".
 *
 * Time complexity O(N+M), where N and M number of characters in input string and pattern
 */
public class SmallestWindowSubstring
{
    public String findSubString(String str, String pattern){
        Map<Character, Integer> charFrequencyMap = new HashMap<>();

        int windowStart = 0,  matched =0;
        int minLength = str.length()+1, subStrStart = 0;
        for(char ch : pattern.toCharArray()){
            charFrequencyMap.put(ch, charFrequencyMap.getOrDefault(ch, 0)+1);
        }

        for(int windowEnd =0; windowEnd< str.length(); windowEnd++){
            char rChar = str.charAt(windowEnd);
            if(charFrequencyMap.containsKey(rChar)) {
                charFrequencyMap.put(rChar, charFrequencyMap.get(rChar)-1);
                if(charFrequencyMap.get(rChar) >=0){
                    matched++;
                }
            }

            while(matched == pattern.length()){
                if(minLength > windowEnd -windowStart+1);{
                    minLength = windowEnd -windowStart+1;
                    subStrStart = windowStart;
                }

                char lChar = str.charAt(windowStart++);

                if(charFrequencyMap.containsKey(lChar)){
                    if(charFrequencyMap.get(lChar)==0){
                        matched--;
                    }
                    charFrequencyMap.put(lChar, charFrequencyMap.get(lChar)+1);
                }
            }
        }
        return minLength> str.length()? "" : str.substring(subStrStart, subStrStart+minLength);
    }


    public static void main(String args[]){
        SmallestWindowSubstring s = new SmallestWindowSubstring();
        System.out.println(s.findSubString("abdabca", "abc"));
    }
}
