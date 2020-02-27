package matrix;

import java.util.ArrayList;

/**
 * Input matrix
 *  1 2 3
 *  4 5 6
 *  7 8 9
 *
 * Output matrix
 *  1
 *  2 4
 *  3 5 7
 *  6 8
 *  9
 */

public class PrintAntidiagonal {

    public static ArrayList<ArrayList> printAntiDiagonal(int [][] arr) {
        ArrayList<ArrayList> output = new ArrayList<ArrayList>();

        int n=arr[0].length;
        for(int i=0;i<n;i++){
            ArrayList upper = new ArrayList();
            for(int j=0;j<=i;j++){
                upper.add(arr[j][i-j]);
            }
            output.add(upper);
        }
        for(int i=1;i<n;i++){
            ArrayList lower = new ArrayList();
            for(int j=i;j<n;j++){
                lower.add(arr[j][n-j+i-1]);
            }
            output.add(lower);
        }

        return output;
    }

    public static void main(String arg[]) {
        int arr[][] = {{1,2,3},{4,5,6},{7,8,9}};

        ArrayList<ArrayList> output = printAntiDiagonal(arr);

        for(int i =0; i< output.size(); i++) {
            for(int j=0; j< output.get(i).size(); j++) {
                System.out.print(output.get(i).get(j));
            }
            System.out.println();
        }
    }
}
