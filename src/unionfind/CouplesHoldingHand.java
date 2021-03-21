package unionfind;

/**
 *
 * Example 1:
 *
 * Input: row = [0, 2, 1, 3]
 * Output: 1
 * Explanation: We only need to swap the second (row[1]) and third (row[2]) person.
 * Example 2:
 *
 * Input: row = [3, 2, 0, 1]
 * Output: 0
 * Explanation: All couples are already seated side by side.
 *
 */
class DSU {
    public int count;
    private int[] size;
    private int[] root;

    public DSU(int N){
        this.count = N;
        size = new int[N];
        root = new int[N];

        for(int i=0; i< N; i++){
            root[i] = i;
        }
    }

    public int find(int x){
        if(root[x] != x){
            root[x] = find(root[x]);
        }
        return root[x];
    }

    public void union(int x, int y){
        int u = find(x);
        int v = find(y);

        if(u == v) return;

        if(size[u] <= size[v]){
            root[u] = v;
            size[v]++;
        } else {
            root[v] = u;
            size[u]++;
        }
        count--;
    }

}
public class CouplesHoldingHand
{
    public int minSwapsCouples(int[] row) {
        int N = row.length/2;
        DSU dsu = new DSU(N);

        for(int i =0; i< N; i++){
            int x = row[i*2];
            int y = row[i*2 +1];
            dsu.union(x/2, y/2);
        }
        return N - dsu.count;
    }

    /**
     * Another approach from Erichto
     */
    public boolean match(int a, int b){
        return (a ^ b) == 1;
    }
    public void swap(int arr[], int i, int j){
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public int minSwapsCouplesItr(int[] row) {
        int operations =0;
        for(int i =0; i< row.length; i+=2){
            if(!match(row[i], row[i+1])){
                for(int j =i+1; i< row.length; j++){
                    if(match(row[i], row[j])){
                        swap(row, i+1, j);
                        operations++;
                        break;
                    }
                }
            }
        }
        return operations;
    }

    public static void main(String arg[]){
        CouplesHoldingHand c = new CouplesHoldingHand();
        int nums[] = {0, 2, 1, 3};
        System.out.println(c.minSwapsCouplesItr(nums));
    }
}
