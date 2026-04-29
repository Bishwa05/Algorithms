package strings;

import java.util.Set;

public class ReverseVowel {

    public static String reverseVowels(String s) {
        // TODO: Write your code here
        int p1 = 0;
        int p2 = s.length() -1;
        char[] charArr = s.toCharArray();
        Set<Character> vSet = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

        StringBuilder sb = new StringBuilder();
        while (p1 <= p2) {
            char charB = charArr[p1];
            char charE = charArr[p2];
            if (vSet.contains(charB) && vSet.contains(charE)) {
                char c = charArr[p1];
                charArr[p1] = charArr[p2];
                charArr[p2] = c;

                p1++;
                p2--;
            } else if (vSet.contains(s.charAt(p1))) {
                p2--;
            } else if (vSet.contains(s.charAt(p2))) {
                p1++;
            } else {
                p1++;
                p2--;
            }
        }
        return new String(charArr);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("DesignGUrus"));
    }
}
