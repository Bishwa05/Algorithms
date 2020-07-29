package bitmanipulation;

public class AddTwoNumberInBinaryRepresentation {

    public int addTwoNumbersWithoutArithmeticOperator(int num1,int num2){
        while(num2 != 0){
            int carry = num1 & num2;
            num1 = num1 ^ num2;
            num2 = carry << 1;
        }
        return num1;
    }

    public static void main(String arg[]) {

        AddTwoNumberInBinaryRepresentation a = new AddTwoNumberInBinaryRepresentation();
        System.out.println(a.addTwoNumbersWithoutArithmeticOperator(64,36));
    }
}
