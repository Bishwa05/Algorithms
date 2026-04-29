package heap;

import java.util.PriorityQueue;

public class MaximizeCapital {
    public int findMaximumCapital(int[] capital, int[] profits, int noOfProjects, int initialCapital) {
        int n = profits.length;
        PriorityQueue<Integer> minCapitalHeap = new PriorityQueue<>(n, (i1, i2) -> capital[i1] - capital[i2]);
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(n, (i1, i2) -> profits[i2] - profits[i1]);

        // insert all project capitals to a min-heap
        for (int i = 0; i < n; i++) {
            minCapitalHeap.offer(capital[i]);
        }

        // let's try to find a total of 'numberOfProjects' best projects
        int availableCapital = initialCapital;

        for (int i = 0; i < noOfProjects; i++) {
            // find all projects that can be selected within the available capital and insert
            // them in a max-heap
            while(!minCapitalHeap.isEmpty() &&
                    minCapitalHeap.peek() <= availableCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll());
            }

            // terminate if we are not able to find any project that can be completed within
            // the available capital
            if (maxProfitHeap.isEmpty()) {
                break;
            }
            // select the project with the maximum profit
            availableCapital += profits[maxProfitHeap.poll()];
        }
        return availableCapital;
    }

    public static void main(String[] args) {
        MaximizeCapital sol = new MaximizeCapital();
        int result = sol.findMaximumCapital(new int[] { 0, 1, 2 },
                new int[] { 1, 2, 3 }, 2, 1);
        System.out.println("Maximum capital: " + result);
        result = sol.findMaximumCapital(new int[] { 0, 1, 2, 3 },
                new int[] { 1, 2, 3, 5 }, 3, 0);
        System.out.println("Maximum capital: " + result);
    }
}
