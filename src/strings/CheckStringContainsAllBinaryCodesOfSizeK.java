package strings;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
 * Leetcode : 1461. Check If a String Contains All Binary Codes of Size K
 *
 */
public class CheckStringContainsAllBinaryCodesOfSizeK {
    public boolean hasAllCodes(String s, int k) {
        int need = 1<<k;
        Set<String> got = new HashSet<>();

        for(int i = k; i<=s.length(); i++) {
            String a = s.substring(i-k, i);
            if(!got.contains(a)) {
                got.add(a);
                need --;
                if(need == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckStringContainsAllBinaryCodesOfSizeK c = new CheckStringContainsAllBinaryCodesOfSizeK();
        String s = "00110110";
        int k = 2;
        System.out.println(c.hasAllCodes(s, k));
    }
}
