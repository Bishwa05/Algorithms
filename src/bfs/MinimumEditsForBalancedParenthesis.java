package bfs;

import java.util.*;

public class MinimumEditsForBalancedParenthesis
{

    public boolean isBalanced(String x){
        int count =0;

        for(int i=0; i< x.length(); i++){
            if(x.charAt(i) =='(') count++;
            if(x.charAt(i) ==')') count--;

            if (count <0) return false;
        }
        return count ==0;

    }

    public List<String> getValidParenthesisString(String s){
        Queue<String> q = new LinkedList();
        List<String> res = new ArrayList<>();
        Map<String,Boolean>visited = new HashMap<>();

        q.add(s);
        //for 1st layer
        boolean found = false;
        while(!q.isEmpty()){
            String x =q.poll();
            if(visited.containsKey(x)) continue;
            visited.put(x,true);

            if(isBalanced(x)) {
                res.add(x);
                // continue;
                found = true;
            }
            if(found) continue;

            for(int i =0; i<x.length(); i++){
                if(x.charAt(i) =='(' || x.charAt(i) ==')') {
                    String y = x.substring(0, i) + x.substring(i + 1);
                    q.add(y);
                }
            }
        }
        return res;
    }


    public static void main(String arg[]){
        String s = "(a)())()";
        MinimumEditsForBalancedParenthesis m = new MinimumEditsForBalancedParenthesis();

        m.getValidParenthesisString(s).forEach(e -> System.out.println(e));

    }
}
