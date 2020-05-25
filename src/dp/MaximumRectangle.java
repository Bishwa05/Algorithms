package dp;

import java.util.Stack;

/**
 * Algorithm:
 * 1. Read the first row and put into an array x
 * 2. calculate max area from array x, as  a histogram.
 * 3. Read other rows if col value found 0 update col of x to 0 else add.
 * 4. calculate area after each each row and update max area.
 *
 * Accepted in leetcode.
 *
 */
public class MaximumRectangle {

    public int findMaxAreaHistogram(int[] arr){
        int area =0;
        int maxArea = 0;

        Stack<Integer> s = new Stack();

        int i =0;
        while(i<arr.length) {
            if(s.isEmpty() || arr[i]>=arr[s.peek()]){
                s.add(i);
                i++;
            } else {
                int top = s.pop();

                if (s.isEmpty()) {
                    area = arr[top] * i;
                } else {
                    area = arr[top] * (i - s.peek() - 1);
                }

                maxArea = Math.max(maxArea, area);
            }

        }

        while (!s.isEmpty()) {
            int top = s.pop();

            if (s.isEmpty()) {
                area = arr[top] * i;
            } else {
                area = arr[top] * (i - s.peek() - 1);
            }

            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }

    public int findMaxArea(char[][] ch){
        if(ch.length ==0) return 0;
        if(ch[0].length == 0) return 0;

        int arr[] = new int[ch[0].length];

        for(int i=0; i<ch[0].length; i++){
            arr[i]  = ch[0][i]-'0';
        }

        int max =findMaxAreaHistogram(arr);


        for(int i=1; i<ch.length;  i++){
            for(int j =0; j<  ch[0].length; j++){
                if(ch[i][j]=='1') {
                    arr[j] = arr[j] + ch[i][j] - '0';
                } else{
                    arr[j] = 0;
                }
            }
            max =Math.max(max, findMaxAreaHistogram(arr));
        }
        return max;
    }

    public static void main(String arg[]){
        char[][] ch = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        MaximumRectangle m = new MaximumRectangle();

        System.out.println(m.findMaxArea(ch));
    }
}
