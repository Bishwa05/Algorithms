package bitmanipulation;

import java.util.Scanner;

public class XorSequence {

    /**
     * 3
     * 2 4
     * 2 8
     * 5 9
     */
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        for (int qItr = 0; qItr < q; qItr++) {


            int l = sc.nextInt();

            int r = sc.nextInt();

            long result = xorSequence(l, r);

            System.out.println("Hello" + result);
        }
    }

    /**
     *
     *
     *
     * arr[0] =0;
     *         for(int i=1; i< arr.length; i++){
     *             arr[i] = arr[i - 1] ^ i;
     *         }
     *         int xorCount = arr[l];
     *         for(int j=l+1; j< arr.length; j++){
     *             xorCount = arr[j] ^ xorCount;
     *         }
     *         return xorCount;
     */

    public static long xorSequence(int l, int r) {
        //int[] arr = new int[r+1];

        int x= 0;
        int prevx=0;
        for(int i=1; i<l; i++){
            x = x ^ i;
            prevx = prevx^x;
        }

        int y =x;
        int prevy=0;
        for(int i=l; i<= r; i++){
            y = y ^ i;
            prevy = prevy^y;

            //System.out.println(prevy+"="+y);
        }
        System.out.println(prevx+":"+prevy);
        int xorCount = prevy;

        return xorCount;
    }

}
