package binarysearch;

public class FindSquareRoot {
    public static int findSquareRoot(int val) {
        int result = val;
        if(val==0 || val ==1)
            return result;

        int end = val;
        int n = end;

        for(int start =0; start< n; start++){
            int mid = (start + end)/2;

            int sqr = mid * mid;
            if(sqr==val)
                return mid;
            if(sqr<val) {
                result = mid;
                start = mid+1;
            }
            else
                end= mid-1;

        }
        return result;
    }

    public static void main(String arg[]){
        System.out.println(findSquareRoot(8));
    }
}
