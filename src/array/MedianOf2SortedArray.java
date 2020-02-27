package array;

/**
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 */

public class MedianOf2SortedArray {

    public static double getMedian(int num1[], int num2[]) {
        double median;
        int p1 = 0; int p2 =0; int i=0;
        int m = num1.length;
        int n = num2.length;

        int mergedInt[] = new int[m+n];

        while(p1< m || p2< n){
            if (p1<m && p2<n) {
                if(num1[p1] < num2[p2]) {
                    mergedInt[i] = num1[p1];
                    p1++;
                } else {
                    mergedInt[i] = num2[p2];
                    p2++;
                }
            } else if(p1<m) {
                mergedInt[i] = num1[p1];
                p1++;
            } else{
                mergedInt[i] = num2[p2];
                p2++;
            }
            i++;
        }

        int tl = m+n;
        if(tl %2 ==0) {
            median = (mergedInt[tl/2] +mergedInt[tl/2-1])/2.0;
        } else {
            median =  mergedInt[tl/2];
        }


        return median;
    }

    public static void main(String arg[]) {
        int num1[] = {1,2};
        int num2[] = {3,4};

        System.out.println(getMedian(num1, num2));
    }
}
