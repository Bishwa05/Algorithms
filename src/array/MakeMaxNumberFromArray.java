package array;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Array contains numbers like,
 *  365, 97 -> 97365
 *  7, 9, 97 -> 9977
 *
 *  There are 2 approaches
 *  1st approach is
 *      1. Find the element which has most digits in the input array(lets say X)
 *      2. Lets say X has 4 digits.
 *      3. Iterate through each of the element and convert all other elements to 4 digits
 *          like, 9 becomes 9999
 *              97 becomes 9797
 *              956 becomes 9569
 *              7 becomes 7777
 *              derived value : 9999 9797 9569 7777
 *              actual value as output : 9 97 956 7
 *     4. Sort based on derived value and concat the  actual values.
 *
 *  2nd approach is (This one handles duplicate).
 *      1. Read each element from array and make the first element as root of a binary tree.
 *      2. Iterate through the input array and add elements to binary tree.
 *      3. While inserting an element to binary tree try to make a binary search tree.
 *      4. The numbers should not be compared with other tree node numerically.
 *          like we got in order, 956, 97, 9, 7
 *              root becomes 956
 *              97 becomes right child of 956 (97 > 956 digit position comparision)
 *              9 becomes right child of 97 (9 > 97 digit position comparision )
 *              7 becomes left child of 956 (7< 956 digit position comparision )
 *         Inorder traversal : 7 956 97 9
 *         Output Seqence : 9 97 956 7 (just reverse during traversal)
 *      5. Now do inorder traversal and put the elements into an deque from last to first.
 *          probably use addFirst()
 */

class DerivedNumber {
    int actualVal;
    long derivedVal;

    public DerivedNumber(int actualVal, int n){
        this.actualVal = actualVal;
        String s = Integer.toString(actualVal);
        StringBuilder sb = new StringBuilder(s);
        StringBuilder ans = new StringBuilder();
        while (ans.length() <= n + 1)
            ans.append(sb);

        s = ans.toString().substring(0, n + 1);
        derivedVal = Long.parseLong(s);
    }

}
public class MakeMaxNumberFromArray {



    public static String prepareNumber1(int [] arr) {

        //find the max length
        int maxLen =0;
        for(int i=0; i< arr.length; i++) {
            String s1 = Integer.toString(arr[i]);
            int len = s1.length();
            maxLen = (maxLen>len)?maxLen:len;
        }

        ArrayList<DerivedNumber> dnList =
                new ArrayList();
        for (int i = 0 ; i < arr.length; i++)
            dnList.add(new DerivedNumber(arr[i], maxLen));

        //sort on modified value
        Collections.sort(dnList, (p1, p2) ->
                (int)(p2.derivedVal - p1.derivedVal));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dnList.size(); i++)
            sb.append(new StringBuilder
                    (Long.toString(dnList.get(i).actualVal)));

        return sb.toString();
    }

    public static void main(String arg[]) {
        int arr [] = {7,9,97};
        System.out.println(prepareNumber1(arr));
    }

}
