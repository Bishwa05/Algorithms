package strings;

/**
 *
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 */
public class IntegerToRoman {

    public static String intToRoman(int num)  {
        int [] arabics = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String [] roman = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();

        for(int i=0; i< arabics.length; i++){
            while(num-arabics[i] >0) {
                sb.append(roman[i]);
                num = num -arabics[i];
            }
        }

        return sb.toString();

    }

    public static void main(String arg[]) {

        int num =1994;//MCMXCIII
        System.out.println(intToRoman(num));

    }
}
