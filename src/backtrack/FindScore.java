package backtrack;

import java.util.Stack;

/**
 * Given a balanced parentheses string s, return the score of the string.
 *
 * The score of a balanced parentheses string is based on the following rule:
 *
 * "()" has score 1.
 * AB has score A + B, where A and B are balanced parentheses strings.
 * (A) has score 2 * A, where A is a balanced parentheses string.
 *
 *
 *  Example 1:
 *
 * Input: s = "()"
 * Output: 1
 * Example 2:
 *
 * Input: s = "(())"
 * Output: 2
 * Example 3:
 *
 * Input: s = "()()"
 * Output: 2
 * Example 4:
 *
 * Input: s = "(()(()))"
 * Output: 6
 */
public class FindScore
{

    int[] list;
    public int findScore(String s){

        Stack<Integer> st = new Stack();
        int n = s.length();
        list = new int[n];
        for(int i=0; i<n; i++){
            if(s.charAt(i) ==')'){
                int j = st.pop();
                list[j] = i;
            } else{
                st.push(i);
            }
        }


        return findScore(0, n-1);
    }

    public int findScore(int l, int h){
        //if(h<0) return 1;
        if(l+1==h) return 1;
        int mid = list[l];

        if(mid == h) return 2* findScore(l+1, h-1);
            return  findScore(l, mid) + findScore(mid+1, h);

    }

    public static void main(String arg[]){
        String x = "(()(()))"; //6
        FindScore f = new FindScore();
        System.out.println(f.findScore(x));
    }
}
