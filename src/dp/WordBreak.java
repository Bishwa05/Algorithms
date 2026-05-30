package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode 139. Word Break
 */
public class WordBreak
{
    /**
     * O(2^n)
     */
    public boolean wordBreak (String s, List<String> wordDict)
    {
        boolean ans = false;
        if (s.isEmpty()) {
            return true;
        }

        for (String x : wordDict) {
            if (s.startsWith(x)) {
                String y = s.substring(x.length());
                ans = ans || wordBreak(y, wordDict);
            }
        }
        return ans;
    }

    /**
     * Time complexity is  O(n*m)
     */
    public boolean wordBreakDP (String s, Set<String> dict)
    {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true; //set first to be true, why?
        //Because we need initial state

        for (int i = 0; i < s.length(); i++) {
            //should continue from match position
            if (!t[i])
                continue;

            for (String a : dict) {
                int len = a.length();
                int end = i + len;
                if (end > s.length())
                    continue;

                if (t[end])
                    continue;

                if (s.substring(i, end).equals(a)) {
                    t[end] = true;
                }
            }
        }

        return t[s.length()];
    }

    //--------------------------------------------
    public boolean wordBreakFaster (String s, List<String> wordDict)
    {
        boolean[] visited = new boolean[s.length() + 1];
        return helper(s, wordDict, visited, 0);
    }

    public boolean helper (String s, List<String> wordDict, boolean[] visited, int index)
    {
        visited[index] = true;
        if (index == s.length()) {
            return true;
        }
        for (String word : wordDict) {
            if (s.indexOf(word, index) == index && !visited[index + word.length()]) {
                if (helper(s, wordDict, visited, index + word.length())) {
                    return true;
                }
            }
        }
        return false;
    }

    //----------------------Another approach-----------------------------

    public boolean wordBreak3(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        Set<String> wordSet = new HashSet<>(wordDict);

        for(int i = 1; i <=s.length(); i++) {
            for (int j = i-1; j >= i; j--) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }



    public static void main (String arg[])
    {
        //        String s = "leetcode";
        //        String[] wordDict = {"leet", "code"};

        //        String s = "applepenapple";
        //        String[] wordDict = {"apple", "pen"};

        String s = "catsandog";
        String[] wordDict = { "cats", "dog", "sand", "and", "cat" };
        WordBreak w = new WordBreak();
        // System.out.println(w.wordBreak(s, Arrays.asList(wordDict)));
        //  System.out.println(w.wordBreakDPHelper(s, Arrays.asList(wordDict)));
        System.out.println(w.wordBreakFaster(s, Arrays.asList(wordDict)));
    }
}
