package dp;

public class StoneGame
{
    public boolean stoneGame (int[] piles)
    {
        int N = piles.length;

        // dp[i+1][j+1] = the value of the game [piles[i], ..., piles[j]].
        int[][] dp = new int[N + 2][N + 2];
        for (int size = 1; size <= N; ++size)
            for (int i = 0; i + size <= N; ++i) {
                int j = i + size - 1;
                int parity = (j + i + N) % 2;  // j - i - N; but +x = -x (mod 2)
                if (parity == 1)
                    dp[i + 1][j + 1] = Math.max(
                        piles[i] + dp[i + 2][j + 1],
                        piles[j] + dp[i + 1][j]);
                else
                    dp[i + 1][j + 1] = Math.min(
                        -piles[i] + dp[i + 2][j + 1],
                        -piles[j] + dp[i + 1][j]);
            }

        return dp[1][N] > 0;
    }

    /**
     *
     * Approach 2
     * @param
     */
    public boolean stoneGame2(int[] piles) {
        int i =0;
        int j = piles.length -1;
        int sumAlex = 0, sumLee=0;

        while(i<j){
            sumAlex += Math.max(piles[i], piles[j]);
            sumLee += Math.min(piles[i], piles[j]);
            i++;
            j--;
        }
        if(sumAlex > sumLee) return true;
        return false;
    }


    public static void main (String arg[])
    {
        int[] piles = { 5, 3, 4, 5 };
        StoneGame s = new StoneGame();
        System.out.println(s.stoneGame(piles));

    }
}
