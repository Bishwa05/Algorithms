package dfs;

/**
 *
 * Not tested with submission, hope it will work.
 *
 * 364. Nested List Weight Sum II
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8. (four 1's at depth 1, one 2 at depth 2)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 17. (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
public class NestedListWeightSumII
{
    int count = 0;
    public int getWeight(String x, int i, int n, int maxDep, int[] depth){

        if( i== n) return count;
        if(x.charAt(i)==']') {
            depth[0]--;
        }

        if(x.charAt(i)=='['){
            depth[0]++;
        }
        if(x.charAt(i)-'0'>0 && x.charAt(i)-'0'<9){
            count += (x.charAt(i)-'0') * (maxDep - depth[0]);
        }

        getWeight(x, i+1, n, maxDep, depth);

        return count;
    }


    public static void main(String arg[]){
        NestedListWeightSumII n = new NestedListWeightSumII();
        //String x = "[[1,1],2,[1,1]]";
        String x = "[1,[4,[6]]]";
        int dep = 1;
        int maxDep = 1;
        for(char c : x.toCharArray()){
            if('['==c){
                dep++;
            } else if(']'==c){
                dep--;
            }
            maxDep = Math.max(dep, maxDep);
        }


        int[] arr = {0};
        System.out.println(n.getWeight(x, 0, x.length()-1,maxDep, arr));

    }
}
