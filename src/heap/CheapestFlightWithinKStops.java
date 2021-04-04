package heap;

/**
 *
 * Example 1:
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 1
 * Output: 200
 *
 * Input:
 * n = 3, edges = [[0,1,100],[1,2,100],[0,2,500]]
 * src = 0, dst = 2, k = 0
 * Output: 500
 *
 */

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightWithinKStops
{

    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int K){
        int [][] g = new int[n][n];

        for(int[] f: flights){
            g[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) ->a[0]-b[0]
        );

        heap.offer(new int[]{0, src, K+1});

        while(!heap.isEmpty()){
            int[] cur = heap.poll();
            int price = cur[0], place = cur[1], remainingStops = cur[2];

            if(place == dst) return price;

            if(remainingStops >0){
                for(int i =0; i< n; i++){
                    if(g[place][i]>0){
                        heap.offer(new int[]{price+g[place][i], i, remainingStops-1});
                    }
                }
            }
        }
        return -1;
    }


    public int findCheapestPrice2(int n, int[][] flights, int src, int dst, int K) {
        int min = Integer.MAX_VALUE;
        int[][] graph = new int[n][n];
        int[] minPrices = new int[n];
        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            graph[start][end] = flight[2];
        }
        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> prices = new LinkedList<>();
        q.add(src);
        prices.add(0);
        while (!q.isEmpty() && K >= 0) {
            K--;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int start = q.poll();
                int priceTillNow = prices.poll();
                for (int j = 0; j < n; j++) {
                    int price = graph[start][j];
                    if (price > 0) {    //there is a flight
                        int curPrice = priceTillNow + price;
                        int oldPrice = minPrices[j];
                        //If there is a cheaper flight with lesser stops do not add it to q
                        if (oldPrice == 0 || oldPrice > curPrice) {//pruning
                            minPrices[j] = curPrice;
                            q.add(j);
                            prices.add(curPrice);
                            if (j == dst && min > curPrice) {
                                min = curPrice;
                            }
                        }
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
