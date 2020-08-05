package backtrack;

import java.util.Stack;

public class FindScore
{

    int[] list;
    public int findScore(String s){

        Stack<Integer> st = new Stack();
        int n = s.length();
        list = new int[n];
        for(int i=0; i<n; i++){
            if(s.charAt(i) ==')'){
                int j = st.pop();
                list[j] = i;
            } else{
                st.push(i);
            }
        }


        return findScore(0, n-1);
    }

    public int findScore(int l, int h){
        //if(h<0) return 1;
        if(l+1==h) return 1;
        int mid = list[l];

        if(mid == h) return 2* findScore(l+1, h-1);
            return  findScore(l, mid) + findScore(mid+1, h);

    }

    public static void main(String arg[]){
        String x = "(()(()))"; //6
        FindScore f = new FindScore();
        System.out.println(f.findScore(x));
    }
}
