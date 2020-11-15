package array;

import java.util.Arrays;

/**
 * A variant of activity scheduling.
 */
public class MinPlatformRequiredForStation
{
    /**
     *
     *  int arr[] = { 1, 2, 3, 8, 10, 11 };
     *  int dep[] = { 10, 7, 19, 12, 20, 30 };
     *
     */

    public int findMinPlatform(int arr[], int dep[]){
        Arrays.sort(arr); // 1,2,3,8,10,11
        Arrays.sort(dep); // 7,10,12,19,20,30
        int i =1;
        int j =0;

        int no =1;

        while(i<arr.length){
            if(arr[i]<dep[j]){
                no++;
            } else {
                j++;
            }
            i++;
        }
        return no;
    }

    public static void main(String args[]){
        int arr[] = { 1, 2, 3, 8, 10, 11 };
        int dep[] = { 10, 7, 19, 12, 20, 30 };
        MinPlatformRequiredForStation m = new MinPlatformRequiredForStation();
        System.out.println(m.findMinPlatform(arr, dep));
    }

}
