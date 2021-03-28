package dp;

/**
 * https://leetcode.com/problems/create-maximum-number/
 * 321. Create Maximum Number
 *
 * You are given two integer arrays nums1 and nums2 of lengths m and n respectively. nums1 and nums2 represent the digits of two numbers. You are also given an integer k.
 *
 * Create the maximum number of length k <= m + n from digits of the two numbers. The relative order of the digits from the same array must be preserved.
 *
 * Return an array of the k digits representing the answer.
 *
 * Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
 * Output: [9,8,6,5,3]
 *
 */
public class CreateMaxNumber
{
    private String max(String s1, String s2){
        return (s1.compareTo(s2))<0? s2: s1;
    }

    //calculate max in 1 array
    public String[] helper(int[]A, int k){
        int m = A.length;
        String[][] dp = new String[m+1][k+1];
        for(int i=0; i<=m; i++){
            for(int l =0; l<=k; l++){
                String chooseAi = (i==0 || l==0)?"": dp[i-1][l-1] + A[i-1];
                String ignoreAi = (i==0)?"": dp[i-1][l];
                dp[i][l] = max(chooseAi, ignoreAi);
            }
        }
        return dp[m];
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k){
        String[] max1 = helper(nums1, Math.min(nums1.length, k));
        String[] max2 = helper(nums2, Math.min(nums2.length, k));

        //merge 2 max arrays
        String ans="";
        for(int t =0; t<=k; t++){
            int len1 = Math.min(nums1.length, t);
            int len2 = Math.min(nums2.length, k-t);

            if(len1 + len2 !=k) continue;

            String ans1 = max1[len1];
            String ans2 = max2[len2];
            StringBuilder tmp = new StringBuilder();
            while(tmp.length() <k){
                char ch;
                if(ans1.compareTo(ans2)>=0){
                    ch = ans1.charAt(0);
                    ans1 = ans1.substring(1);
                } else{
                    ch = ans2.charAt(0);
                    ans2 = ans2.substring(1);
                }
                tmp.append(ch);
            }
            ans = max(ans, tmp.toString());
        }

        int[] tmp = new int[ans.length()];
        for(int i =0; i<tmp.length; i++){
            tmp[i] = ans.charAt(i) -'0';
        }
        return tmp;
    }

    public static void main(String arg[]){
        int []nums1 = {3,4,6,5};
        int []nums2 = {9,1,2,5,8,3};

        CreateMaxNumber c = new CreateMaxNumber();
        for (int i : c.maxNumber(nums1, nums2, 5)) {
            System.out.println(i);
        }

    }
}
