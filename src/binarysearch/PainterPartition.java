package binarysearch;

public class PainterPartition {

    static int mod = 10000003;
    public static long paintPartition(int a, int b, int c[]) {
        long l =1;
        long r = 0;
        r = c.length;
        r = r*b;

        long ans = -1;
        while(l<=r){
            long mid = l+ (r-l)/2;

            if(possibleToPaint(a, b, c, mid)){
                ans =  mid;
                r = mid-1;
            } else{
                l =  mid+1;
            }

        }
    return ans % mod;
    }

    public static boolean possibleToPaint(int noOfPainters, long timePerUnit, int fenchLength[], long timePerPainter) {
        int paintersUsed = 1;
        long currentTimeUsed =0;

        for(int length : fenchLength){
            if(length*timePerUnit > timePerPainter) {
                return false;
            }

            currentTimeUsed +=  length*timePerUnit;

            if(currentTimeUsed>timePerPainter){
                paintersUsed++;
                currentTimeUsed =  length*timePerUnit;
            }
        }
        return paintersUsed <=noOfPainters;
    }

    public static void main(String args[]) {
        // paintPartition();
    }
}
