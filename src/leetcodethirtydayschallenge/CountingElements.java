package leetcodethirtydayschallenge;
/**
 *
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 *
 * If there're duplicates in arr, count them seperately.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,3]
 * Output: 2
 * Explanation: 1 and 2 are counted cause 2 and 3 are in arr.
 * Example 2:
 *
 * Input: arr = [1,1,3,3,5,5,7,7]
 * Output: 0
 * Explanation: No numbers are counted, cause there's no 2, 4, 6, or 8 in arr.
 * Example 3:
 *
 * Input: arr = [1,3,2,3,5,0]
 * Output: 3
 * Explanation: 0, 1 and 2 are counted cause 1, 2 and 3 are in arr.
 * Example 4:
 *
 * Input: arr = [1,1,2,2]
 * Output: 2
 * Explanation: Two 1s are counted cause 2 is in arr.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 1000
 * 0 <= arr[i] <= 1000
 *
 */

import java.util.*;

public class CountingElements {

    // Failed submission for  input {1,1,2} accepted ans was 2;
    public static int countElements(int arr[]) {
        int count =0;
        Map<Integer, Integer> elementMap = new HashMap();
        for(int i: arr){

            if(elementMap.get(i) ==  null) elementMap.put(i,1 );
            else elementMap.put(i,elementMap.get(i)+1 );
        }

        for(int i: arr){

            if(elementMap.get(i+1) !=  null){
                int val = elementMap.get(i+1);
                if(val>0){
                    count++;
                    elementMap.put(i+1,val-1);
                }
            }

        }
        return count;
    }

    /**
     * This is the accepted solution by leetcode
     * @param arr
     * @return
     */
    public static int countElements2(int arr[]) {
        int count =0;
        Set elementSet = new HashSet();
        for(int i: arr){

            elementSet.add(i);
        }

        for(int i: arr){

            if(elementSet.contains(i+1)){
                count++;
            }

        }
        return count;
    }

    public static void main(String arg[]){
         //int arr[] = {1,2,3};
        // int arr[] ={1,1,3,3,5,5,7,7};
        // int arr[] = {1,3,2,3,5,0};
        // int arr[] = {1,1,2,2,3,3};
        int arr[] = {1,1,2};
        //System.out.println(countElements(arr));
        System.out.println(countElements2(arr));
    }
}
