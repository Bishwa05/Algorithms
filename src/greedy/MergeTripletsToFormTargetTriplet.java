package greedy;

public class MergeTripletsToFormTargetTriplet {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxValues = new int[3];

        // Iterate over triplet
        for (int[] triplet : triplets) {
            // Check if current triplet can contribute to target
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                // update the maxValue of each triplet
                maxValues[0] = Math.max(maxValues[0], triplet[0]);
                maxValues[1] = Math.max(maxValues[1], triplet[1]);
                maxValues[2] = Math.max(maxValues[2], triplet[2]);
            }
        }
        // check If maxValues matches target triplet
        return maxValues[0] == target[0] && maxValues[1] == target[1] && maxValues[2] == target[2];
    }
}
