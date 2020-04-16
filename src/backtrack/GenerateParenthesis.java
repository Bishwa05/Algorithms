package backtrack;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n){
        List output = new ArrayList();
        backtrack(output,"",0,0, n);
        return output;

    }

    public static void backtrack(List<String> output, String currStr,int open, int close, int max){
        if(currStr.length() == max*2){
            output.add(currStr);
            return;
        }

        if(open<max) backtrack(output,currStr+"(",open+1, close, max);
        if(close<open) backtrack(output, currStr+")", open, close+1, max);
    }

    public static void main(String arg[]){
        int n =3;

        generateParenthesis(n).forEach(e -> System.out.println(e));

    }
}
