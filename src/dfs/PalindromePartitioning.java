package dfs;

import java.util.ArrayList;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
 * Leetcode 131. Palindrome Partitioning
 *
 */
public class PalindromePartitioning {

    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();

        if(s == null || s.length() ==0){
            return result;
        }

        ArrayList<String> partition = new ArrayList<>();
        addPalindrome(s, 0, partition, result);
        return result;
    }

    private void addPalindrome(String s, int start, ArrayList<String> partition,
                               ArrayList<ArrayList<String>> result) {
        if(start == s.length()) {
            ArrayList<String> temp = new ArrayList<>();
            result.add(temp);
            return;
        }
        for(int i = start+1; i<= s.length(); i++){
            String str = s.substring(start, i);
            partition.add(str);
            addPalindrome(s, i, partition, result);
            partition.remove(partition.size()-1);
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
}
