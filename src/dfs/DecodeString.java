package dfs;

/**
 *
 * 394. Decode String
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 *
 */
public class DecodeString
{
    private int index = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();

        while(index < s.length()){
            char ch = s.charAt(index);
            if(ch>= '0' && ch <= '9'){
                result.append(decodeRepeatedWord(s));
            } else if(ch == ']'){
                index +=1;
                return result.toString();
            } else {
                index +=1;
                result.append(ch);
            }
        }
        return result.toString();
    }

    private String decodeRepeatedWord(String s){
        int num = 0;
        while(index< s.length()){
            char ch = s.charAt(index);
            if(ch>='0' && ch<='9'){
                num = num*10 + (ch -'0');
                index+=1;
            } else if(ch == '['){
                index += 1;
                String word = decodeString(s);
                StringBuilder sb = new StringBuilder();
                for(int j =0; j<num; j++){
                    sb.append(word);
                }
                return sb.toString();
            }
        }
        return "";
    }
    public static void main(String arg[]){
        DecodeString d = new DecodeString();
        String s = "3[a2[c]]";
        System.out.println(d.decodeString(s));

    }
}
