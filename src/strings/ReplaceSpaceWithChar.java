package strings;

/**
 * Write a method to replace all spaces in a string with ‘%20’
 *
 * Count the number of spaces during the first scan of the string Parse the string again from the end and for each character:
 * » If a space is encountered, store “%20”
 * » Else, store the character as it is in the newly shifted location
 *
 */
public class ReplaceSpaceWithChar {

    static void replaceString(char[] sampleStr) {
        int spaceCount =0, newLength =0;

        for (int i=0; i< sampleStr.length; i++) {
            if(sampleStr[i] ==' ')
                spaceCount++;
        }

        newLength = sampleStr.length + 2*spaceCount;

        char[] finalStr = new char[newLength];

        for (int i = sampleStr.length -1; i >0; i--) {
            if(sampleStr[i] == ' ') {
                finalStr[newLength -1] = '0';
                finalStr[newLength -2] = '2';
                finalStr[newLength -3] = '%';
                newLength = newLength -3;
            } else {
                finalStr[newLength -1] = sampleStr[i];
                newLength = newLength -1;
            }
        }

        System.out.println(finalStr);

    }

    public static void main(String arg[]) {
        char [] sampleStr = {'H','e','l','l','o',' ','W',
                'o','r','l','d',' ','I','n','d','i','a'};
        replaceString(sampleStr);

    }
}
