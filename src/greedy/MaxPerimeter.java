package greedy;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Given an array of stick lengths, use  of them to construct a non-degenerate triange with the maximum possible perimeter. Print the lengths of its sides as  space-separated integers in non-decreasing order.
 *
 * If there are several valid triangles having the maximum perimeter:
 *
 * Choose the one with the longest maximum side.
 * If more than one has that maximum, choose from them the one with the longest minimum side.
 * If more than one has that maximum as well, print any one them.
 * If no non-degenerate triangle exists, print -1.
 *
 * For example, assume there are stick lengths . The triplet will not form a triangle. Neither will  or , so the problem is reduced to  and . The longer perimeter is .
 *
 * Function Description
 *
 * Complete the maximumPerimeterTriangle function in the editor below. It should return an array of  integers that represent the side lengths of the chosen triangle in non-decreasing order.
 *
 * maximumPerimeterTriangle has the following parameter(s):
 *
 * sticks: an integer array that represents the lengths of sticks available
 * Input Format
 *
 * The first line contains single integer , the size of array .
 * The second line contains  space-separated integers , each a stick length.
 *
 * Constraints
 *
 * Output Format
 *
 * Print the lengths of the  chosen sticks as space-separated integers in non-decreasing order.
 *
 * If no non-degenerate triangle can be formed, print -1.
 *
 * Sample Input 0
 *
 * 5
 * 1 1 1 3 3
 * Sample Output 0
 *
 * 1 3 3
 * Explanation 0
 *
 * There are  possible unique triangles:
 *
 * The second triangle has the largest perimeter, so we print its side lengths on a new line in non-decreasing order.
 *
 * Sample Input 1
 *
 * 3
 * 1 2 3
 * Sample Output 1
 *
 * -1
 * Explanation 1
 *
 * The triangle  is degenerate and thus can't be constructed, so we print -1 on a new line.
 *
 * Sample Input 2
 *
 * 6
 * 1 1 1 2 3 5
 * Sample Output 2
 *
 * 1 1 1
 * Explanation 2
 *
 * The triangle (1,1,1) is the only valid triangle.
 */
public class MaxPerimeter {
    // Complete the maximumPerimeterTriangle function below.
    static int[] maximumPerimeterTriangle(int[] sticks) {
        Arrays.sort(sticks);
        int[] maxArray = new  int[3];
        int [] notFound = new int[1];
        notFound[0]=-1;
        int maxPerimeter = 0;
        boolean triangleFound = false;



        for (int i=0, j= i+1, k = j+1 ; k< sticks.length; i++, j++, k++){
            int a = sticks[i];
            int b = sticks[j];
            int c = sticks[k];
            if((a+b)>c) {
                int perimeter = i+j+k;
                triangleFound = true;

                if(perimeter > maxPerimeter) {
                    maxPerimeter = perimeter;
                    maxArray[0] = a;
                    maxArray[1] = b;
                    maxArray[2] = c;
                }
            }
        }

        if(triangleFound)
            return maxArray;
        else
            return notFound;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] sticks = new int[n];

        //String[] sticksItems = scanner.nextLine().split(" ");
        //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {

            sticks[i] = scanner.nextInt();
        }

        int[] result = maximumPerimeterTriangle(sticks);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

        scanner.close();
    }
}