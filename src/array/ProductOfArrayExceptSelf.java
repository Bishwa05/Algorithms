package array;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Input array [1, 2, 3, 4]
 *
 * Output array [24, 12, 8, 6]
 *
 * Without using division operator.
 * Approach : find the left product array and right product array
 * left [1, 1, 2, 6]
 * right [24, 12, 4, 1]
 * Then multiple both arrays
 */
public class ProductOfArrayExceptSelf {

    public static int[] getProductArray(int arr[]) {
        int outArr[] = new int[arr.length];
        int leftArr[] = new int[arr.length];
        int rightArr[] = new int[arr.length];

        leftArr[0] = rightArr[arr.length-1]  = 1;

        for(int i=1; i< arr.length; i++){
            leftArr[i] = arr[i-1] * leftArr[i-1];
        }


        for(int i=arr.length-2; i>=0 ; i--){
            rightArr[i] = arr[i+1] * rightArr[i+1];
        }

        for(int i =0; i< arr.length; i++) {
            System.out.println(leftArr[i] +"**" + rightArr[i]);
            outArr[i] = leftArr[i] * rightArr[i];
        }

        return outArr;


    }

    public static void main(String arg[]) {
        int arr1[] = {1,2,3,4};
        int outputArr[] = getProductArray(arr1);

        for(int i =0; i< outputArr.length; i++) {
            System.out.print(outputArr[i] +",");
        }
    }
}
