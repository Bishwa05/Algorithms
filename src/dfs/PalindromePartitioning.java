package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * Leetcode 131. Palindrome Partitioning
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
 *
 */
public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        if(s == null || s.length() ==0) {
            return result;
        }

        List<String> partition = new ArrayList<>();
        addPalindrome(s, 0, partition, result);
        return result;
    }

    private void addPalindrome(String s, int start, List<String> partition,
                               List<List<String>> result) {
        if(start == s.length()) {
            List<String> temp = new ArrayList<>(partition);
            result.add(temp);
            return;
        }
        for(int i = start+1; i<= s.length(); i++){
            String str = s.substring(start, i);
            if (isPalindrome(str)) {
                partition.add(str);
                addPalindrome(s, i, partition, result);
                partition.remove(partition.size() - 1);
            };
        }
    }

    private boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() -1;
        while(left< right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /***
     * DP approach
     */

    public static List<String> palindromePartitioning(String s){
        List<String> result = new ArrayList<>();

        if(s== null){
            return result;
        }

        if(s.length() <= 1){
            result.add(s);
            return result;
        }

        int length = s.length();
        int[][]table = new int[length][length];

        for(int l =1; l<= length -1; l++) {
            for(int i =0; i<= length -l; i++){
                int j = i+l-1;
                if(s.charAt(i)== s.charAt(j)){
                    if(l ==1 || l==2){
                        table[i][j] = 1;
                    } else {
                        table[i][j] = table[i+1][j-1];
                    }
                    if (table[i][j] == 1){
                        result.add(s.substring(i, j+1));
                    }
                } else {
                    table[i][j] = 0;
                }
            }
        }

    return result;
    }

    public static void main(String args[]){
        PalindromePartitioning p = new PalindromePartitioning();
        p.palindromePartitioning("aabbb").forEach(
            (e) ->
                System.out.println(e)

        );
    }
}
