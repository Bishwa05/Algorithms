package dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 *
 * Example 1:
 *
 * Input: s = "aab"
 * Output: [["a","a","b"],["aa","b"]]
 * Example 2:
 *
 * Input: s = "a"
 * Output: [["a"]]
 *
 */
public class PalindromePartitioning
{

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length()-1;

        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left ++;
            right --;
        }
        return true;
    }

    private void addPalindrome(String s, int start, List<String> partition,
                               List<List<String>> result){
        if(start == s.length()){
            List<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }

        for(int i = start +1; i<= s.length(); i++){
            String str = s.substring(start, i);
            if(isPalindrome(str)){
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size()-1);
            }
        }
    }

    // DFS approach
    public List<List<String>> partition(String s){
        List<List<String>> result = new ArrayList<>();

        if(s == null || s.length() ==0) return result;

        List<String> partition = new ArrayList<>();
        addPalindrome(s, 0, partition, result);
        return result;
    }



    //DP
    public List<List<String>> partition2(String s){
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        List<List<String>> result = new ArrayList<>();
        dfs(result, s, 0, new ArrayList<>(), dp);
        return result;
    }

    public void dfs(List<List<String>> result, String s, int start,
                    List<String> currentList, boolean[][] dp){
        if(start >= s.length()){
            result.add(new ArrayList<>(currentList));
        }

        for(int end = start; end <s.length(); end++){
            if(s.charAt(start) == s.charAt(end) &&
                (end - start<=2 || dp[start+1][end -1])){
                dp[start][end] = true;
                currentList.add(s.substring(start, end+1));
                dfs(result, s, end+1, currentList, dp);
                currentList.remove(currentList.size()-1);
            }
        }
    }
}
