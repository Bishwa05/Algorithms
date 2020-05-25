package dp;

import java.util.HashSet;
import java.util.Set;
/*

Consider the following dictionary
{ i, like, sam, sung, samsung, mobile, ice,
  cream, icecream, man, go, mango}

Input:  ilike
Output: Yes
The string can be segmented as "i like".

Input:  ilikesamsung
Output: Yes
The string can be segmented as "i like samsung"
or "i like sam sung".

 */
public class WordBreakProblem
{
    private static Set<String> dictionary = new HashSet<>();
    static int counter =0;

    public static boolean wordBreak(String word)
    {
        int size = word.length();

        // base case
        if (size == 0)
            return true;

        //else check for all words
        for (int i = 1; i <= size; i++)
        {
            // Now we will first divide the word into two parts ,
            // the prefix will have a length of i and check if it is
            // present in dictionary ,if yes then we will check for
            // suffix of length size-i recursively. if both prefix and
            // suffix are present the word is found in dictionary.

            counter++;
            if (dictionary.contains(word.substring(0,i)) &&
                    wordBreak(word.substring(i,size)))
                return true;
        }

        // if all cases failed then return false
        return false;
    }



    static void wordBreakBacktrack(String str)
    {
        // last argument is prefix
        wordBreakUtil(str, str.length(), "");
    }

    // result store the current prefix with spaces
// between words
    static void wordBreakUtil(String str, int n, String result)
    {
        //Process all prefixes one by one
        for (int i=1; i<=n; i++)
        {
            //extract substring from 0 to i in prefix
            String prefix = str.substring(0, i);

            // if dictionary contains this prefix, then
            // we check for remaining string. Otherwise
            // we ignore this prefix (there is no else for
            // this if) and try next
            if (dictionary.contains(prefix))
            {
                // if no more elements are there, print it
                if (i == n)
                {
                    // add this element to previous prefix
                    result += prefix;
                    System.out.println(result);
                    return;
                }
                wordBreakUtil(str.substring(i, n), n-i,
                        result + prefix + " ");
            }
        }      //end for
    }//end function


    public static void main(String []args)
    {

        // array of strings to be added in dictionary set.
        String temp_dictionary[] = {"mobile","samsung","sam","sung",
                "man","mango","icecream","and",
                "go","i","like","ice","cream"};

        // loop to add all strings in dictionary set
        for (String temp :temp_dictionary)
        {
            dictionary.add(temp);
        }

        // sample input cases
//        System.out.println(wordBreak("ilikesamsung"));
//        System.out.println(counter);

        wordBreakBacktrack("ilikesamsung");

//        System.out.println(wordBreak("iiiiiiii"));
//        System.out.println(wordBreak(""));
//        System.out.println(wordBreak("ilikelikeimangoiii"));
//        System.out.println(wordBreak("samsungandmango"));
//        System.out.println(wordBreak("samsungandmangok"));

    }
}
