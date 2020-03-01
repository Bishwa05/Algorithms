package strings;

public class MultiplyStrings {

    public static String multiply(String num1, String num2) {
        int m = num1.length(); int n = num2.length();
        int val[] = new int[m+n];
        for(int i=m-1; i>=0; --i){
            for(int j = n-1; j>=0; --j) {
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                // To calc carry
                int sum = val[i+j+1] + mul;
                val[i+j] = val[i+j] + sum/10;
                val[i+j+1] = sum%10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i : val){
            if(sb.length() !=0 || i!=0){
                sb.append(i);
            }
        }
        return sb.length() ==0? "0" : sb.toString();

    }

    public static void main(String arg[]) {
        System.out.println(multiply("123","456"));
    }
}
