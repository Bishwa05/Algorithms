package strings;

public class UniqueChars {

    public static boolean isUniqueChar(String x){
        if(x.length()>128) return false;
        boolean[] charArr = new boolean[128];

        for(int i = 0; i<x.length(); i++){
            int ascii = x.charAt(i);
            if(charArr[ascii]) return false;
            charArr[ascii]= true;
        }
        return true;
    }

    public static void main(String arg[]){
        String x = "bishwa";
        System.out.println(isUniqueChar(x));


    }
}
