package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode 1202. Smallest String With Swaps
 * https://leetcode.com/problems/smallest-string-with-swaps/
 */
public class SmallestStringWithSwaps {
    final static int N = 10001;
    boolean[] visited = new boolean[N];
    List<Integer>[] adj = new ArrayList[N];

    private void dfs(String s, int vertex, List<Character> characters, List<Integer> indices) {
        characters.add(s.charAt(vertex));
        indices.add(vertex);
        visited[vertex] = true;

        //traverse the adjacents
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        return "";
    }
}
