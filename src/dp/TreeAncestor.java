package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * You are given a tree with n nodes numbered from 0 to n-1 in the form of a parent array where parent[i] is the parent of node i. The root of the tree is node 0.
 *
 * Implement the function getKthAncestor(int node, int k) to return the k-th ancestor of the given node. If there is no such ancestor, return -1.
 *
 * The k-th ancestor of a tree node is the k-th node in the path from that node to the root.
 *
 *
 */
public class TreeAncestor
{
    int dp[][];

    public TreeAncestor(int n, int[] parent){
        dp = new int[parent.length][31];
        List<List<Integer>> a = new ArrayList<>();
        int root = build(a, parent);

        for(int i=0; i<parent.length; i++){
            Arrays.fill(dp[i], -1);
        }
        dfs(a, root, -1, dp);
    }

    public int getKthAncestor(int node, int k){
        for(int i=30;i>=0 && node!=-1; i--){
            int pow = (int)Math.pow(2, i);
            if(k>=pow){
                k-= pow;
                node = dp[node][i];
            }
        }
        return node;
    }

    public void dfs(List<List<Integer>>a, int index, int parent, int dp[][]){
        dp[index][0] = parent;
        for(int i=1; i<31; i++){
            if(dp[index][i-1]==-1) break;

            dp[index][i] = dp[dp[index][i-1]][i-1];
        }
        int l = a.get(index).size();

        for(int i=0; i<l; i++){
            dfs(a, a.get(index).get(i), parent, dp);
        }
    }

    public int build(List<List<Integer>>a, int parent[]){
        int n = parent.length;

        for(int i=0; i<n; i++)
            a.add(new ArrayList<>());

        int root =0;
        for(int i =0; i<n; i++){
            if(parent[i] ==-1){
                root = i;
                continue;
            }
            int p = parent[i];
            a.get(p).add(i);
        }
        return root;
    }

    public static void main(String arg[]){
        int[] nums = {-1,0,0,1,1,2,2};
        TreeAncestor t = new TreeAncestor(7, nums);

        System.out.println(t.getKthAncestor(3, 1));
        System.out.println(t.getKthAncestor(5, 2));
        System.out.println(t.getKthAncestor(6, 3));
    }
}
