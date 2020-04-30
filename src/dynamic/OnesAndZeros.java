package dynamic;

public class OnesAndZeros {

    /**
     * Recursive approach
     * Time complexity O(2^(n*m))
     */

    public int findMaxForm(String[] strs, int m, int n){
        return findMaxForm(strs, m, n, 0);
    }

    protected int findMaxForm(String[] strs, int m, int n, int index) {

        if(m==0 && n==0){
            return 0;
        }

        if(index==strs.length-1){
            return 0;
        }

        String  currStr =  strs[index];
        int  zero =0;
        int one =0;

        for(int i =0; i< currStr.length(); i++){
            if(currStr.charAt(i)=='0'){
                zero++;
            } else{
                one++;
            }
        }

//        if(m-zero<0 || n-one<0){
//            return findMaxForm(strs, m, n, index+1);
//        }

        int include = 1 + findMaxForm(strs, m-zero, n-one, index+1);
        int notInclude = findMaxForm(strs, m, n, index+1);
        return Math.max(include, notInclude);
    }

    /**
     *
     * Time complexity O(m*n*k)
     */
    public int findMaxFormBottomUp(String[] strs, int m, int n) {
        if (strs.length == 0) return 0;
        int[][][] map = new int[strs.length + 1][m + 1][n + 1];
        for (int i = 1; i <= strs.length; i++) {
            int[] counts = getCounts(strs[i - 1]);
            for (int z = 0; z <= m; z++) {
                for (int o = 0; o <= n; o++) {
                    if (counts[0] > z || counts[1] > o) {
                        map[i][z][o] = map[i - 1][z][o];
                    } else {
                        map[i][z][o] = Math.max(map[i - 1][z][o], 1 + map[i - 1][z - counts[0]][o - counts[1]]);
                    }
                }
            }
        }
        return map[strs.length][m][n];
    }

    private int[] getCounts(String str) {
        int[] res = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') res[0]++;
            else res[1]++;
        }
        return res;
    }

    public static void main(String arg[]){
        OnesAndZeros o = new OnesAndZeros();
//        String[] arr = {"10", "0", "1"};
//        int m = 1; int n = 1;
//        System.out.println(o.findMaxForm(arr, m, n));

        String[] arr = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        System.out.println(o.findMaxForm(arr, m, n));

//        String[] arr = {"10", "001", "111001", "1", "0","101"};
//        int m = 10;
//        int n =5;
//        System.out.println(o.findMaxForm(arr, m, n));

    }
}
