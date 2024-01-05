package bfs;

import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * 1 0 1
 * 1 1 1
 * 1 1 1
 *
 */
public class MakeEntireRowCol0 {

    public void bfs(int[][] mat) {

        Set<Integer> rowset = new HashSet<>();
        Set<Integer> colset = new HashSet<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(0,0));
        int[][] dir = new int [][] {{1,0}, {0,1}, {-1, 0}, {0, -1}};
        Set<Pair> pairSet = new HashSet<>();
        pairSet.add(new Pair<>(0,0));
        while(!q.isEmpty()) {
            Pair<Integer,Integer> index = q.poll();

            if(mat[index.getKey()][index.getValue()] == 0) {
                rowset.add(index.getKey());
                colset.add(index.getValue());
            }

            for(int[] d : dir) {
                int nextX =index.getKey() +d[0];
                int nextY = index.getValue() +d[1];
                if(nextX >=0 && nextX <mat.length && nextY >=0 && nextY<mat[0].length) {
                    Pair<Integer, Integer> p1 = new Pair<>(nextX, nextY);
                    if(!pairSet.contains(p1)) {
                        pairSet.add(p1);
                        q.offer(p1);
                    }

                }
            }
        }

        for(int i = 0; i< mat.length; i++){
            for(int j = 0; j< mat[0].length; j++){
                if(rowset.contains(i)) mat[i][j] = 0;
                if(colset.contains(j)) mat[i][j] = 0;
            }
        }

    }


    public static void main(String[] args) {

        int mat[][] = new int[][]{{1, 1, 1, 1},{1, 1, 1, 1},{1, 1, 1, 0}, {1,1,1,1}};
        MakeEntireRowCol0 m = new MakeEntireRowCol0();
        m.bfs(mat);
        for (int[] ints : mat) {
            System.out.println(ints);
        }
    }
}
