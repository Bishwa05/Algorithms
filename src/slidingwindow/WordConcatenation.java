package slidingwindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * concatenation of all the given words exactly once without any overlapping of words.
 *
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat".
 *
 * Input: String="catcatfoxfox", Words=["cat", "fox"]
 * Output: [3]
 * Explanation: The only substring containing both the words is "catfox".
 */
public class WordConcatenation
{

    // TLE in leetcode
    public List<Integer> findWordConcatenation(String str, String[] words){
        List<Integer> res = new ArrayList<>();
        Map<String, Integer> wordFrequencyMap = new HashMap<>();

        for(String word: words){
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0)+1);
        }

        int wordCount = words.length, wordLength = words[0].length();

        for(int i =0; i<= str.length()-wordCount*wordLength; i++){
            Map<String, Integer> wordSeen = new HashMap<>();
            for(int j =0; j< wordCount; j++){
                int nextWordIndex = i+j * wordLength;
                String word = str.substring(nextWordIndex, nextWordIndex+wordLength);
                if(!wordFrequencyMap.containsKey(word))
                    break;
                wordSeen.put(word, wordSeen.getOrDefault(word, 0)+1);

                if(wordSeen.get(word)> wordFrequencyMap.getOrDefault(word,0))
                    break;

                if(j+1 == wordCount)
                    res.add(i);
            }
        }
        return res;
    }



    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> windowMap = new HashMap<>();

            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (wordMap.containsKey(word)) {
                    windowMap.put(word, windowMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (windowMap.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowMap.put(leftWord, windowMap.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    windowMap.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }

        return result;
    }

    public static void main(String args[]){
        WordConcatenation w = new WordConcatenation();
//        w.findWordConcatenation("catfoxcat", new String[]{"cat", "fox"})
//            .forEach(
//            e-> System.out.println(e)
//        );
        w.findSubstring("catfoxcat", new String[]{"cat", "fox"})
                .forEach(
                        e-> System.out.println(e)
                );
    }
}
