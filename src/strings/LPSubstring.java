package strings;


// ABBACDEEDC --6
public class LPSubstring {
    public static int longestPalSubStr(String X) {
        int n = X.length();

        boolean table[][] = new boolean[n][n];

        //Set the diagonals in the matrix
        //All substrings with length 1 are pallindrome
        int maxLength = 1;
        for(int i=0; i<n; i++)
            table[i][i] = true;

        // check for sub-string of length 2
        int start = 0;
        for(int i=0; i<n-1; i++) {
            if(X.charAt(i) == X.charAt(i+1)){
                table[i][i+1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Form the 2nd diagonal and find the max length.
        //check for lengths greater than 2.
        for(int k=3; k<=n; k++) {
            for(int i=0; i<n-k+1; i++) {
                int j = i+k-1;
                if(table[i+1][j-1] && X.charAt(i) == X.charAt(j)){
                    table[i][j] = true;
                    if(k>maxLength){
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        return  maxLength;
    }

    /**
     * The above method has time complexity of O(n^2) and space complexity O(n^2)
     * In below method we can reduce the space complexity to O(1)
     *
     */

    // expand in both directions of low and high to find
    // maximum length palindrome
    public static String expand(String str, int low, int high)
    {
        int len = str.length();

        // expand in both directions
        while (low >= 0 && high < len &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }

        // return palindromic substring
        return str.substring(low + 1, high);
    }

    public static String longestPalSubStr2(String str, int len)
    {
        // max_str stores the maximum length palindromic substring
        // found so far

        String max_str = "", curr_str;

        // max_length stores the length of maximum length palindromic
        // substring found so far

        int max_length = 0, curr_length;

        // consider every adjacent pair of characters as mid points and
        // expand in both directions to find maximum length palindrome

        for (int i = 0; i < len; i++)
        {
            // find a longest odd length palindrome with str[i] as mid point

            curr_str = expand(str, i, i);
            curr_length = curr_str.length();


            // update maximum length palindromic substring if odd length
            // palindrome has greater length

            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }

            // find a longest even length palindrome with str[i] and
            // str[i+1] as mid points.
            // Note that an even length palindrome has two mid points

            curr_str = expand(str, i, i + 1);
            curr_length = curr_str.length();

            // update maximum length palindromic substring if even length
            // palindrome has greater length

            if (curr_length > max_length)
            {
                max_length = curr_length;
                max_str = curr_str;
            }
        }

        return max_str;
    }

    public static void main(String arg[]){
        String X = "ABBACDEEDC";
        System.out.println(longestPalSubStr(X));
        //System.out.println(findLongestPalindrome(X));
    }
}
