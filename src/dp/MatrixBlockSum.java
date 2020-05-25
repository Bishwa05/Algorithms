package dp;

public class MatrixBlockSum {
    /**
     *
     *
     *
     */

    public int[][] matrixBlockSum(int[][] mat, int K) {

        int M = mat.length;
        int N = mat[0].length;

        int[][] dp = new int[M+1][N+1];

        for(int r= 1; r<=M; r++){
            for(int c = 1; c<=N; c++){
                dp[r][c] = mat[r-1][c-1] - dp[r-1][c-1] + dp[r-1][c] + dp[r][c-1];

            }
        }

        int[][] res = new int[M][N];

        /**
         * TODO: Analysis on this
         */
        for(int r= 0; r<M; r++){
            for(int c = 0; c<N; c++){
                int r0 = Math.max(r-K, 0);
                int c0 = Math.max(c-K, 0);

                int r1 = Math.min(r+K+1, M);
                int c1 = Math.min(c+K+1, N);

                res[r][c] = dp[r1][c1] - dp[r0][c1]- dp[r1][c0] + dp[r0][c0];

            }
        }

        return res;

    }

    public static void main(String arg[]) {
       int[][] mat = {{1,2,3}, {4,5,6}, {7,8,9}};
       int K = 1;
        MatrixBlockSum m = new  MatrixBlockSum();
        System.out.println(m.matrixBlockSum(mat, K));
    }

}
