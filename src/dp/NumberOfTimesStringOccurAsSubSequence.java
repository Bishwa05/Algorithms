package dp;

public class NumberOfTimesStringOccurAsSubSequence
{
    public int count(String a, String b, int m, int n){
        if((m==0 && n ==0) || n==0) return 1;

        if(m ==0) return 0;

        if(a.charAt(m-1) == b.charAt(n-1)){
            return count(a, b, m-1, n-1)+
                count(a, b, m-1, n);
        } else {
            return count(a, b, m-1, n);
        }
    }

    public int countDP(String a, String b){
        int m = a.length();
        int n = b.length();

        int[][]dp = new int[m+1][n+1];

        // if 1st string empty
        for(int i =0; i<=n; i++){
            dp[0][i] = 0;
        }

        // if 2nd string empty
        for(int i =0; i<=m; i++){
            dp[i][0] = 1;
        }


        for(int i =1; i<=m; i++){
            for(int j =1; j<=n; j++){
                if(a.charAt(i-1)== b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+ dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String arg[]){
        NumberOfTimesStringOccurAsSubSequence n = new NumberOfTimesStringOccurAsSubSequence();
        String a = "thisisthat";
        String b = "tht";

        System.out.println(n.count(a, b, a.length(), b.length()));
        System.out.println(n.countDP(a, b));
    }

}
