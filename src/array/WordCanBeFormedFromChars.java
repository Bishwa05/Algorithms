package array;

import java.util.Arrays;

/**
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 */
public class WordCanBeFormedFromChars {

    public static int countCharacters(String[] words, String chars) {
        int[] charArr = new int[26];
        int totalCount = 0;

        char[] char1 = chars.toCharArray();
        for(char c: char1){
            charArr[c-'a']++;
        }

        for(String word :  words){
            int[] tempArray = Arrays.copyOf(charArr, charArr.length);
            int charCount =0;

            char[] char2 = word.toCharArray();

            for(char x : char2){
                if(tempArray[x-'a']>0){
                    tempArray[x-'a']--;
                    charCount++;
                }

            }
            if(word.length() == charCount) {
                totalCount+=charCount;
            }
        }
        return totalCount;
    }

    public static void main(String arg[]) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }
}
