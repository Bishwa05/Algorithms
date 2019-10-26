package graph;

/**
 * The Floyd Warshall Algorithm is for solving the All Pairs Shortest Path problem.
 * The problem is to find shortest distances between every pair of
 * vertices in a given edge weighted directed Graph.
 *
 *            10
 *         (0)------->(3)
 *         |         /|\
 *        5|          |
 *         |          | 1
 *        \|/         |
 *         (1)------->(2)
 *              3
 */
public class FloydWarshall {
    final static int INF = 9999, V = 4;

    static void floydWarshall(int [][] graph) {
        int dist[][] = new int[V][V];
        int i, j, k;

        for (i = 0; i < V; i++) {
            for (j = 0; j < V; j++)
                dist[i][j] = graph[i][j];
        }

        /*
              the shortest distances consider only the vertices in
               set {0, 1, 2, .. k-1} as intermediate vertices
         */
        for (k = 0; k < V; k++)
        {
            // Pick all vertices as source one by one
            for (i = 0; i < V; i++)
            {
                // Pick all vertices as destination for the
                // above picked source
                for (j = 0; j < V; j++)
                {
                    // If vertex k is on the shortest path from
                    // i to j, then update the value of dist[i][j]
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        System.out.println("i :"+i+" : j : "+j+" : k :"+k);
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
            System.out.println("For each Node calculation");
            printSolution(dist);
            System.out.println("******************************");
        }

        printSolution(dist);

    }

    static void  printSolution(int dist[][])
    {
        System.out.println("The following matrix shows the shortest "+
                "distances between every pair of vertices");
        for (int i=0; i<V; ++i)
        {
            for (int j=0; j<V; ++j)
            {
                if (dist[i][j]==INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j]+"   ");
            }
            System.out.println();
        }
    }

    public static void main(String arg[]) {
        /* Let us create the following weighted graph */

        int graph[][] = { {0,   5,  INF, 10},
                {INF, 0,   3, INF},
                {INF, INF, 0,   1},
                {INF, INF, INF, 0}
        };

        // Print the solution
        floydWarshall(graph);
    }
}
