package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Write a function to generate the generalized abbreviations of a word.
 *
 * Example:
 * Given word = "word", return the following list (order does not matter):
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 *
 *
 */
public class GeneralizedAbbreviation
{
    public List<String> generateAbbreviations(String word){
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }

    // i is the current position
    // k is the count of consecutive abbreviated characters
    private void backtrack(List<String> ans, StringBuilder builder, String word, int i, int k){
        int len = builder.length(); // keep the length of builder
        if(i == word.length()){
            if (k != 0) builder.append(k); // append the last k if non zero
            ans.add(builder.toString());
        } else {
            // the branch that word.charAt(i) is abbreviated
            backtrack(ans, builder, word, i + 1, k + 1);

            // the branch that word.charAt(i) is kept
            if (k != 0) builder.append(k);
            builder.append(word.charAt(i));
            backtrack(ans, builder, word, i + 1, 0);
        }
        builder.setLength(len); // reset builder to the original state
    }


    public static void main(String arg[]){
        String word = "word";
        GeneralizedAbbreviation g = new GeneralizedAbbreviation();
        g.generateAbbreviations(word).forEach(e -> System.out.println(e));
    }
}
