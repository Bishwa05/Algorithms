package array;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicatesInAnArray {

    /**
     * This method only works if element value <= n.
     * Time complexity O(n) and space complexity O(1)
     *
     *
     * @param arrA
     */

    /**
     * [1,2,1,2,3,3] --> 1
     * [2,1,3,5,3,2] --> 3
     * [1,2,3,4,5,6] -- -1
     */

    public static void hasDuplicates(int[] arrA) {

        for (int i = 0; i < arrA.length; i++) {
            //check if element is negative, if yes the we have found the duplicate
            if (arrA[Math.abs(arrA[i])] < 0) {
                System.out.println("Array has duplicates : " + Math.abs(arrA[i]));
            } else {
                arrA[Math.abs(arrA[i])] = arrA[Math.abs(arrA[i])] * -1;
            }
        }
    }

    public static void hasDuplicateWithNolimitation(int [] a) {
        Set dupSet = new HashSet();
        for(int i=0; i<a.length; i++) {
            if(!dupSet.contains(a[i])) {
                dupSet.add(a[i]);
            } else {
                System.out.println("First Duplicate found : " +a[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int a[] = {1, 6, 5, 2, 3, 3, 2};
        //hasDuplicates(a);
        hasDuplicateWithNolimitation(a);
    }
}
