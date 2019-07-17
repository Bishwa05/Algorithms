package strings;

import java.util.HashMap;
import java.util.Map;

public class LCSLength {

    /**
     * Worst case happens when there is no common subsequence present in strings
     * Time complexity O(2^(m+n))
     * @param X
     * @param Y
     * @param m
     * @param n
     * @return
     */
    public static int lcsLength(String X, String Y, int m, int n) {

        if(m ==0 || n==0) {
            return 0;
        }

        if(X.charAt(m-1) == Y.charAt(n-1)){
            return lcsLength(X, Y, m-1, n-1) +1;
        }

        return Integer.max(lcsLength(X,Y,m-1,n),
                lcsLength(X,Y,m,n-1));
    }


    /**
     *  This is top down approach.
     *  Time complexity O(mn)
     *  Space complexity O(mn)
     * @param X
     * @param Y
     * @param m
     * @param n
     * @param lookup
     * @return
     */
    public static int lcsLength2(String X, String Y, int m, int n,
                                 Map<String,Integer> lookup) {

        if(m ==0|| n==0){
            return 0;
        }
        String key = m+"|"+n;

        if(!lookup.containsKey(key)) {

            if(X.charAt(m-1) == Y.charAt(n-1)) {
                lookup.put(key,lcsLength2(X,Y,m-1,n-1,lookup)+1);
            } else {
                lookup.put(key,Integer.max(lcsLength2(X,Y,m-1,n,lookup),
                        lcsLength2(X,Y,m,n-1,lookup)));
            }
        }
        return lookup.get(key);
    }


    /**
     * This is bottom up approach
     * Time complexity O(mn)
     * Space Complexity O(mn)
     * @param X
     * @param Y
     * @return
     */
    public static int lcsLength3(String X, String Y){

        int m = X.length(), n = Y.length();

        int[][] T = new int [m+1][n+1];

        for(int i=1; i<= m; i++) {
            for(int j =1; j<=n; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)){
                    T[i][j] = T[i-1][j-1] +1;
                } else {
                    T[i][j] = Integer.max(T[i-1][j], T[i][j-1]);
                }
            }
        }
        return T[m][n];
    }



    public static void main(String args[]) {
        String X = "ABCDEFGH";
        String Y = "DEFGHIJK";

        System.out.println(lcsLength(X,Y, X.length(), Y.length()));
        System.out.println(lcsLength2(X,Y, X.length(), Y.length(), new HashMap()));
        System.out.println(lcsLength3(X,Y));
    }
}