package dp;

/**
 * Recurrence becomes
 *
 *      dp[i][j] = dp[i-1][j-1] , if str[i] == pat[j] || pat[j]  == '.'
 *               = dp[i][j-2] , if pat[j] = '*', 0 Occurrences
 *               = dp[i-1][j] , if pat[j] = '*', str[i] == pat[j-1] || pat[j-1]=='.'
 *               = false
 */
public class RegularExpressionMatching {

    public static boolean matchRegex(char[] text, char[] pat){
        boolean[][] dp = new boolean[text.length+1][pat.length+1];

        dp[0][0] = true;
        //For patterns a*, a*b, a*b*c
        for(int i=1;  i<dp[0].length; i++){
            if(pat[i-1]=='*') {
                dp[0][i] = dp[0][i-2];
            }
        }

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j< dp[0].length; j++) {
                if(pat[j-1]=='.'|| pat[j-1]== text[i-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pat[j-1] =='*') {
                    dp[i][j] = dp[i][j-2];

                    if(pat[j-2]=='.'|| pat[j-2]==text[i-1]) {
                        dp[i][j]= dp[i][j] | dp[i-1][j];
                    }
                }  else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[text.length][pat.length];

    }

    public static void main(String arg[]) {
        System.out.println(matchRegex("Bishwa".toCharArray(),"B.sh.a".toCharArray()));
    }
}
