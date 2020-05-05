package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. Letter Combinations of a Phone Number
 * Leetcode
 *
 */
public class LetterCombinationOfPhoneNumber {


    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};


    List<String> output = new ArrayList<String>();

    public void backtrack(String combination, String next_digits) {
        // if there is no more digits to check
        if (next_digits.length() == 0) {
            // the combination is done
            output.add(combination);
        }
        // if there are still digits to check
        else {
            // iterate over all letters which map
            // the next available digit
            String digit = next_digits.substring(0, 1);
            String letters = phone.get(digit);
            for (int i = 0; i < letters.length(); i++) {
                String letter = phone.get(digit).substring(i, i + 1);
                // append the current letter to the combination
                // and proceed to the next digits
                backtrack(combination + letter, next_digits.substring(1));
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    /**
     *
     */

    HashMap<Character, char[]> dict = new HashMap<Character, char[]>();


    public List<String> letterCombinationsDFS(String digits) {
        dict.put('2',new char[]{'a','b','c'});
        dict.put('3',new char[]{'d','e','f'});
        dict.put('4',new char[]{'g','h','i'});
        dict.put('5',new char[]{'j','k','l'});
        dict.put('6',new char[]{'m','n','o'});
        dict.put('7',new char[]{'p','q','r','s'});
        dict.put('8',new char[]{'t','u','v'});
        dict.put('9',new char[]{'w','x','y','z'});


        List<String> result = new ArrayList<String>();
        if(digits==null||digits.length()==0){
            return result;
        }

        char[] arr = new char[digits.length()];
        helper(digits, 0, dict, result, arr);

        return result;
    }

    private void helper(String digits, int index, HashMap<Character, char[]> dict,
                        List<String> result, char[] arr){
        if(index==digits.length()){
            result.add(new String(arr));
            return;
        }

        char number = digits.charAt(index);
        char[] candidates = dict.get(number);
        for(int i=0; i<candidates.length; i++){
            arr[index]=candidates[i];
            helper(digits, index+1, dict, result, arr);
        }
    }

    public List<String> letterCombinationsBFS(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> l = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return l;
        }

        l.add("");

        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            String option = map.get(digits.charAt(i));

            for (int j = 0; j < l.size(); j++) {
                for (int p = 0; p < option.length(); p++) {
                    temp.add(new StringBuilder(l.get(j)).append(option.charAt(p)).toString());
                }
            }

            l.clear();
            l.addAll(temp);
        }

        return l;
    }

    public static void main(String arg[]) {
        String  digits  ="236";
        LetterCombinationOfPhoneNumber l =  new  LetterCombinationOfPhoneNumber();
//        System.out.println(l.letterCombinationsDFS(digits));
//        System.out.println("---------------------");
//        System.out.println(l.letterCombinationsBFS(digits));

        System.out.println(l.letterCombinations(digits));

    }

}
