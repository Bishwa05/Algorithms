package binarysearch;

/**
 * This solution is passed in interviewbit
 */
public class FindSquareRoot {
    public static int findSquareRoot(int A) {
        if(A==0 || A==1) return A;

        long start = 0, end = A/2 + 1;

        while(start<=end){
            long mid = (start+end)/2;
            if(mid*mid ==A){
                return (int)mid;
            }else if(mid*mid<A){
                start = mid+1;
            }else {
                end = mid-1;
            }
        }
        return (int)end;
    }

    public static void main(String arg[]){
        System.out.println(findSquareRoot(8));
    }
}
