package dynamic;

public class MaximumSubArraySumWith1Deletion {
    public int maxSum(int[] a){
        int n = a.length;
        int ans = a[0];
        int sufNoDel = a[0];
        int suffDel = 0;

        for(int i=1; i<n; i++){
            suffDel = Math.max(suffDel+a[i], sufNoDel);
            sufNoDel = Math.max(sufNoDel+a[i], a[i]);
            ans =  Math.max(Math.max(ans, suffDel), sufNoDel);

        }
        return ans;
    }

    public static void main(String arg[]){
        int []arr= {1,-2,0,3};
        MaximumSubArraySumWith1Deletion  m = new MaximumSubArraySumWith1Deletion();
        System.out.println(m.maxSum(arr));
    }
}
