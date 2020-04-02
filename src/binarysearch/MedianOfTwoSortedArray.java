package binarysearch;

/**
 * Time complexity should be log(m+n)
 *
 *
 *
 * A: 1,4,5
 * B: 2, 3
 *
 * Find the partition in array A before which all the elements come in left side
 *
 * [1]      [4 5]
 * [2 3]    []
 */
public class MedianOfTwoSortedArray {
    public static double findMedianSortedArray(int []A, int []B){
        int m = B.length;
        int n = A.length;

        if(n ==0 && m ==0) {
            return 0;
        }
        if(n>m){
            return findMedianSortedArray(B,A);
        }

        if(n ==0){
            if(m%2 ==0){
                return (B[m/2] + B[m/2-1])/2;
            }
            return B[m/2];
        }

        int l = 0;
        int r = n;

        int totalOnLeft = (n+m+1)/2;
        //After which partition the ans is going to be.
        while(l<=r){
            int mid = l+ (r-l)/2;
            int bLeftCount = totalOnLeft - mid;

            int aPartitionLeft =  -1;
            int aPartitionRight;

            if(mid ==0){
                aPartitionLeft =  Integer.MIN_VALUE;
                aPartitionRight = A[0];

            } else if(mid<n) {
                aPartitionLeft = A[mid-1];
                aPartitionRight =  A[mid];
            } else {
                aPartitionLeft = A[mid-1];
                aPartitionRight =  Integer.MAX_VALUE;
            }

            int bPartitionLeft =  -1;
            int bPartitionRight;
            if(bLeftCount ==0) {
                bPartitionLeft =  Integer.MIN_VALUE;
                bPartitionRight =  B[0];
            } else if(bLeftCount <m){
                bPartitionLeft = B[bLeftCount-1];
                bPartitionRight = B[bLeftCount];
            }
            else{
                bPartitionLeft = B[bLeftCount-1];
                bPartitionRight = Integer.MAX_VALUE;
            }

            if(aPartitionLeft > bPartitionRight){
                r = mid-1;
            } else if(bPartitionLeft > aPartitionRight){
                l = mid+1;
            } else{
                if((n+m)%2 ==0){
                    return (Integer.max(aPartitionLeft, bPartitionLeft) +
                            Integer.min(aPartitionRight, bPartitionRight))/2.0;
                }
                return Math.max(aPartitionLeft, bPartitionLeft);
            }
        }

    return -1;

    }

    public static void main(String arg[]){
        int arr1[] = {1,4,5};
        int arr2[] = {2,3};

        System.out.println(findMedianSortedArray(arr1, arr2));
    }
}
