package graph;

/**
 * Given an undirected graph and a starting node, determine the lengths of the shortest paths from the starting node to all other nodes in the graph. If a node is unreachable, its distance is -1. Nodes will be numbered consecutively from  to , and edges will have varying distances or lengths.
 *
 * For example, consider the following graph of 5 nodes:
 *
 * Begin	End	Weight
 * 1	2	5
 * 2	3	6
 * 3	4	2
 * 1	3	15
 * image
 * Starting at node , the shortest path to  is direct and distance . Going from  to , there are two paths:  at a distance of  or  at a distance of . Choose the shortest path, . From  to , choose the shortest path through  and extend it:  for a distance of  There is no route to node , so the distance is .
 *
 * The distances to all nodes in increasing node order, omitting the starting node, are 5 11 13 -1.
 *
 * Function Description
 *
 * Complete the shortestReach function in the editor below. It should return an array of integers that represent the shortest distance to each node from the start node in ascending order of node number.
 *
 * shortestReach has the following parameter(s):
 *
 * n: the number of nodes in the graph
 * edges: a 2D array of integers where each  consists of three integers that represent the start and end nodes of an edge, followed by its length
 * s: the start node number
 * Input Format
 *
 * The first line contains , the number of test cases.
 *
 * Each test case is as follows:
 * - The first line contains two space-separated integers  and , the number of nodes and edges in the graph.
 * - Each of the next  lines contains three space-separated integers , , and , the beginning and ending nodes of an edge, and the length of the edge.
 * - The last line of each test case has an integer , denoting the starting position.
 *
 * Constraints
 *
 *
 *
 *
 *
 *
 * If there are edges between the same pair of nodes with different weights, they are to be considered as is, like multiple edges.
 *
 * Output Format
 *
 * For each of the  test cases, print a single line consisting  space separated integers denoting the shortest distance to the  nodes from starting position  in increasing order of their labels, excluding .
 *
 * For unreachable nodes, print .
 *
 * Sample Input
 *
 * 1
 * 4 4
 * 1 2 24
 * 1 4 20
 * 3 1 3
 * 4 3 12
 * 1
 * Sample Output
 *
 * 24 3 15
 * Explanation
 *
 * The graph given in the test case is shown as :
 *
 * image
 * * The lines are weighted edges where weight denotes the length of the edge.
 *
 * The shortest paths followed for the three nodes 2, 3 and 4 are as follows :
 *
 * 1/S->2 - Shortest Path Value : 24
 *
 * 1/S->3 - Shortest Path Value : 3
 *
 * 1/S->3->4 - Shortest Path Value : 15
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Disjkstra {
    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) {
        FastReader in=new FastReader();
        int t1=in.nextInt();
        for(int gj=0;gj<t1;gj++){
            int n=in.nextInt();
            int m=in.nextInt();
            long w[][]=new long [n+1][n+1];
            for (long[] row: w)
                Arrays.fill(row, 1000000l);
            for(int i=0;i<m;i++){
                int x=in.nextInt(),y=in.nextInt();
                long cmp=in.nextLong();
                if(w[x][y]>cmp){
                    w[x][y]=cmp; w[y][x]=cmp;
                }
            }
            Stack <Integer> t=new Stack<Integer>();
            int src=in.nextInt();
            for(int i=1;i<=n;i++){
                if(i!=src){
                    t.push(i);
                }
            }
            Stack <Integer> p=new Stack<Integer>();
            p.push(src);
            w[src][src]=0;
            while(!t.isEmpty()){
                int min=989997979,loc=-1;
                for(int i=0;i<t.size();i++) {
                    w[src][t.elementAt(i)]=Math.min(w[src][t.elementAt(i)],
                            w[src][p.peek()]+w[p.peek()][t.elementAt(i)]);
                    if(w[src][t.elementAt(i)]<=min){
                        min=(int) w[src][t.elementAt(i)];
                        loc=i;
                    }
                }
                p.push(t.elementAt(loc));
                t.removeElementAt(loc);
            }
            for(int i=1;i<=n;i++){
                if(i!=src && w[src][i]!=1000000l){
                    System.out.print(w[src][i]+" ");
                }
                else if(i!=src){
                    System.out.print("-1"+" ");
                }
            }System.out.println();
        }
    }}