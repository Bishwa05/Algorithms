package dynamic;

/**
 * 413. Arithmetic Slices
 * Leetcode
 */
public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] A) {
        int startSlice = 0;
        int total = 0;
        for (int i =2; i<A.length; i++) {
            if (A[i] - A[i-1] == A[i-1] - A[i-2] ) {
                total += 1 +i-3-startSlice+1;
            } else {
                startSlice = i-1;
            }
        }
        return total;
    }


    public int numberOfArithmeticSlicesSimple(int[] a) {
        int len  = a.length;
        int dp[] = new int[len];
        int sum = 0;
        if(a.length < 3 ){
            return 0;
        }

        for (int i=2;i<len;i++){
            if(a[i] - a[i-1] == a[i-1] - a[i-2]){
                dp[i] = dp[i-1]+1;
                sum += dp[i];
            }
        }
        return sum;
    }

    public static void main(String arg[]) {
        int arr[] = {1,2,3,8,9,10};
        ArithmeticSlices a = new  ArithmeticSlices();
        System.out.println(a.numberOfArithmeticSlices(arr));
    }

}
