package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. Restore IP Addresses
 *
 * Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.
 *
 * A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "25525511135"
 * Output: ["255.255.11.135","255.255.111.35"]
 * Example 2:
 *
 * Input: s = "0000"
 * Output: ["0.0.0.0"]
 * Example 3:
 *
 * Input: s = "1111"
 * Output: ["1.1.1.1"]
 */
public class RestoreIpAddresses
{

    public void find(int num, String str, String s, List<String>al){
        if(num>4) return;

        if(s.length()==0 && num == 4){
            al.add(str.substring(0, str.length()-1));
            return;
        }

        for(int i=0; i<s.length(); i++){
            String cut = s.substring(0, i+1);

            if(cut.length()<=3){
                int n = Integer.parseInt(cut);

                if(n>0 && n<=255 && cut.charAt(0)!='0'){
                    find(num+1, str+cut+".",s.substring(i+1), al);
                } else if(cut.length()==1&& n==0){
                    find(num+1, str+cut+".", s.substring(i+1), al);
                }
            }
        }
    }

    public List<String> restoreIpAddresses(String s){
        List<String> al = new ArrayList<>();
        find(0, "", s, al);
        return al;
    }
}
