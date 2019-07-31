package array;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.Scanner;

/**
 * Pills vs Germs
 * You’re given a multi-layered rack in the form of a matrix with m rows and n columns.
 * Each cell is occupied either by a red pill (marked by r), a blue pill (marked by b)
 * or a germ (marked by x). A red pill can kill adjacent germs (if any) in horizontal,
 * vertical and diagonal directions whereas a blue pill can kill adjacent germs (if any)
 * in horizontal and vertical direction only. Initially the pills are inactive.
 * Once active, they can act on adjacent germs. You need to find the count of the
 * remaining germs in the rack once the pills are activated.
 *
 * Input Format
 * The first line contains a single integer t, denoting the number of test cases.
 * The first line of each test case contains two spare separated integers m and n
 * denoting the number of rows and number of columns in the matrix respectively.
 * Following m lines each contains n elements.
 *
 * Output Format
 * For each test case print the count of remaining germs.
 *
 * Constraints
 * 1 <= t <= 1000
 * 1 <= m <= 100
 * 1 <= n <= 100
 *
 * Sample Input
 * 4
 * 2 2
 * bx
 * xx
 * 2 2
 * rb
 * br
 * 2 2
 * xx
 * xx
 * 1 5
 * xxbxx
 * Sample Output
 * 1
 * 0
 * 4
 * 2
 */
public class PillsVsGerms {

    public static void displayMatrix(int rows, int cols, char[][] charArr){
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(charArr[i][j]);
            }
            System.out.println();
        }
    }

    public static void printOutput(char[][] charArr){
        int rows = charArr.length;
        int cols = charArr[0].length;

        int count =0;
        for(int i=0; i<rows; i++) {
            for (int j = 0; j < cols; j++) {
                if('x'==charArr[i][j])
                    count++;
            }
        }
        System.out.println(count);
    }

    public static void handleHorVert(char[][] charArr,int rows, int cols, int i, int j, char c){
        if(j+1 < cols && (charArr[i][j+1] =='x'))
            charArr[i][j+1]='0';
        if(j-1 >= 0 && (charArr[i][j-1] =='x'))
            charArr[i][j-1]='0';

        if(i+1 < rows && (charArr[i+1][j] =='x'))
            charArr[i+1][j]='0';
        if(i-1 >= 0 && (charArr[i-1][j] =='x'))
            charArr[i-1][j]='0';
    }

    public static void handlediagonals(char[][] charArr,int rows, int cols, int i, int j, char c){
        if((i-1 >=0 && j-1>=0) && (charArr[i-1][j-1] =='x'))
            charArr[i-1][j-1]='0';
        if((i-1 >=0 && j+1 < cols ) && (charArr[i-1][j+1] =='x'))
            charArr[i-1][j+1]='0';

        if((i+1 < rows && j+1 < cols) && (charArr[i+1][j+1] =='x'))
            charArr[i+1][j+1]='0';
        if((i+1 < rows && j-1 >=0 ) && (charArr[i+1][j-1] =='x'))
            charArr[i+1][j-1]='0';
    }


    public static void main(String arg[]) {

        Scanner sc = new Scanner(System.in);
        //System.out.println("No of Test cases");
        int test = sc.nextInt();

        for (int p = 0; p < test; p++) {
            //System.out.println("Enter the rows");
            int rows = sc.nextInt();
            //System.out.println("Enter the columns");
            int cols = sc.nextInt();

            char[][] charArr = new char[rows][cols];

            //System.out.println("Enter the Array");
            for (int i = 0; i < rows; i++) {
                String row = sc.next();
//            for(int j =0; j< row.length(); j++)
//                charArr[i][j]=row.charAt(j);
                charArr[i] = row.toCharArray();
            }


            //displayMatrix(rows, cols, charArr);

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if ('b' == charArr[i][j]) {
                        handleHorVert(charArr, rows, cols, i, j, 'b');

                    }

                    if ('r' == charArr[i][j]) {
                        handleHorVert(charArr, rows, cols, i, j, 'r');
                        handlediagonals(charArr, rows, cols, i, j, 'r');
                    }
                }
            }
            //displayMatrix(rows, cols, charArr);

            printOutput(charArr);

        }
    }
}
