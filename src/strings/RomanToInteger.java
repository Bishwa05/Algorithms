package strings;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public static int romanToInt(String roman) {
        if(roman == null || roman.length() ==0)
            return 0;

        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I',1);
        romanValues.put('V',5);
        romanValues.put('X',10);
        romanValues.put('L',50);
        romanValues.put('C',100);
        romanValues.put('D',500);
        romanValues.put('M',1000);

        int length = roman.length();
        int result = romanValues.get(roman.charAt(length -1));

        for(int i = length -2; i>=0; i--) {
            if(romanValues.get(roman.charAt(i))>= romanValues.get(roman.charAt(i+1))) {
                result = result + romanValues.get(roman.charAt(i));
            } else  {
                result = result - romanValues.get(roman.charAt(i));
            }
        }
        return result;
    }

    public static void main(String arg[]) {
        //String roman="MCMXCIII"; //1993
        String roman="MCMXCIV";
        System.out.println(romanToInt(roman));
    }
}
