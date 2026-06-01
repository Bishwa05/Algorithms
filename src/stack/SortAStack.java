package stack;

import java.util.Stack;

public class SortAStack
{

    public static void sort(Stack<Integer> s){

        if(!s.isEmpty()) {
            int val = s.pop();
            sort(s);
            backtrack(s, val);
        }
    }

    public static void backtrack(Stack<Integer> stack, int val){
        if(stack.isEmpty() || val> stack.peek()){
            stack.push(val);
        } else {
            int val2 = stack.pop();
            backtrack(stack, val);
            stack.push(val2);
        }
    }

// Another approach
    public static Stack<Integer> sortStack(Stack<Integer> input) {
        Stack<Integer> tmpStack = new Stack<Integer>();

        while(!input.isEmpty()) {
            int val = input.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek()>val) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(val);
        }
        return tmpStack;
    }


    public static void main(String arg[]){
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(6);
        s.push(9);
        s.push(8);

        sort(s);

        System.out.println(s);

    }
}
