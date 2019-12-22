package dynamic;

/**
 * Given a 2-D sqaure matrix cost[][] of order N*N where cost[i][j] represents the cost of passing through
 * cell[i][j]. Total cost to reach a particular cell is the sum of costs of all the cells in that path
 * (including the starting and end cell) we can go either downward or rightward
 * (i, j+1) or (i+1,j)
 *
 * [ 1, 2, 5, 8
 *   4, 2, 1, 7
 *   4, 3, 2, 3]
 *
 */


public class MinCostPath {

    public static int minPathCostRec(int cost[][], int m, int n){

        if(m==0 || n==0)
            return cost[0][0];

        // First row
        if(m==0)
            return minPathCostRec(cost, m, n-1)+ cost[0][n];

        //First column
        if(n ==0)
            return minPathCostRec(cost, m-1, n) + cost[m][0];

        int x = minPathCostRec(cost, m, n-1);
        int y = minPathCostRec(cost, m-1, n);

        return Math.min(x,y) + cost[m-1][n-1];//m-1, n-1 for array index


    }

    static int MEM[][] = new int[4][5];

    public static int minPathCostMemoized(int cost[][], int m, int n) {
        // if the value for the cell is already computed,
        // dont compute it again
        if(MEM[m][n] !=0){
            return MEM[m][n];
        }

        if(m==0 || n==0)
            MEM[m][n] = cost[0][0];

        // First row
        else if(m==0)
            MEM[m][n] = minPathCostRec(cost, m, n-1)+ cost[0][n];

        //First column
        else if(n ==0)
            MEM[m][n] = minPathCostRec(cost, m-1, n) + cost[m][0];
        else {
            int x = minPathCostRec(cost, m, n-1);
            int y = minPathCostRec(cost, m-1, n);

            MEM[m][n] = Math.min(x,y)+cost[m-1][n-1]; // m-1, n-1 for array index
        }

        return MEM[m][n];
    }

    public static int minPathCostBottomUp(int cost[][], int m, int n) {
        int MEM[][] = new int[m][n];

        MEM[0][0] = cost[0][0];

        //Top row
        for(int j =1; j<n; j++)
            MEM[0][j] = MEM[0][j-1]+ cost[0][j];

        //Left column
        for(int i=1; i<m; i++)
            MEM[i][0] = MEM[i-1][0] + cost[i][0];

        //Filling other cells
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                MEM[i][j] = Math.min(MEM[i-1][j], MEM[i][j-1])+ cost[i][j];
            }
        }
        return MEM[m-1][n-1];
    }

    public static void main(String arg[]){
        int arr[][] = {{1,2,5,8},
                        {4,2,1,7},
                        {4,3,2,3}};

        int rows = arr.length;
        int cols = arr[0].length;
        System.out.println(minPathCostRec(arr,  rows, cols));

        System.out.println(minPathCostMemoized(arr, rows, cols));

        System.out.println(minPathCostBottomUp(arr, rows, cols));
    }
}
