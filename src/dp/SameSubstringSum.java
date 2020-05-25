package dp;

/**
 *
 * Find the length of longest substring of a given string of digits, such that sum of digits in
 * the first half and second  half of the substring is same.
 *
 * ip :  142124
 * op : 6
 *
 * ip : 9430723
 * op : 4
 *
 */
public class SameSubstringSum {

    static int maxSubstrLength(int arr[]){
        int N = arr.length;
        int sum[][] = new int[N][N];
        int maxLen =0;

        // lower diagonal of matrix not used (i>j)
        for(int i =0; i<N; i++)
            sum[i][i] =  arr[i];

        for(int len =2; len<=N; len++){
            //pick i and j for current substring
            for(int i=0; i<N-len+1; i++){
                int j = i+len-1;
                int k = len/2;
                // calculate value of sum[i][j]
                sum[i][j] = sum[i][j-k] + sum[j-k+1][j];
                // update if len is even, left and right sums are same
                // len is more than maxlen
                if(len%2 ==0 && sum[i][j-k] == sum[j-k+1][j] && len> maxLen)
                    maxLen = len;
            }
        }
        return maxLen;
    }

    public static void main(String arg[]) {
        //int arr[] = {1,4,2,1,2,4};
        int arr[] = {9,4,3,0,7,2,3};
        System.out.println(maxSubstrLength(arr));
    }
}
