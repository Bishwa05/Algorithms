package tree.other;

import java.util.Arrays;

/**
 *
 * developers fixing the logs, there are list of kubernetes pods, and logs can come in format [1, 3, 10] this means at the 3rd place we need 10 pods and [2, -1, 8] means where ever there are less than 8 pods change it to 8
 *
 * Input nodes can be 2,3,4 and after getting [1,3,10]
 * it would be 2,3,10 and after getting [2, -1, 8] it would be 8,8,10
 *
 */
public class SegmentTreeWithLazyPropagation {
    static int[] tree; // stores min of segment (to know if lazy applies)
    static int[] lazy; // pending "raise all to this value" update
    static int n;

    // Build segment tree
    static void build(int node, int start, int end, int[] arr) {
        lazy[node] = 0;
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end)/2;
            build(2 * node, start, mid, arr);
            build(2 * node +1, mid+1, end, arr);
            tree[node] = Math.min(tree[2*node], tree[2*node +1]);
        }
    }

    // push lazy down to children
    static void pushDown(int node) {
        if (lazy[node] > 0) {
            // Apply lazy to children
            tree[2 * node] = Math.max(tree[2*node], lazy[node]);
            lazy[2 * node] = Math.max(lazy[2 * node], lazy[node]);

            tree[2 * node + 1] = Math.max(tree[2 * node + 1], lazy[node]);
            lazy[2 * node + 1] = Math.max(lazy[2 * node + 1], lazy[node]);

            lazy[node] = 0;
        }
    }

    // Type 1: Point update — set arr[idx] = val (1-indexed)
    static void pointUpdate(int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
            lazy[node] = 0;
            return;
        }

        pushDown(node);
        int mid = (start + end)/2;
        if (idx <= mid) {
            pointUpdate(2 * node, start, mid, idx, val);
        } else {
            pointUpdate(2 * node + 1, mid + 1, end, idx, val);
        }
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    // Type 2: Range update — raise all elements below threshold to threshold
    static void rangeRaise(int node, int start, int end, int l, int r, int threshold) {
        if(r < start || end < l) return;
        if (l <= start && end <= r) {
            // Apply raise to this whole segment
            tree[node] = Math.max(tree[node], threshold);
            lazy[node] = Math.max(lazy[node], threshold);
        }
        pushDown(node);
        int mid = (start + end)/2;
        rangeRaise(2 * node, start, mid, l, r, threshold);
        rangeRaise(2 * node + 1, mid + 1, end, l, r, threshold);
        tree[node] = Math.min(tree[2 * node], tree[2 * node + 1]);
    }

    // Query a single point value (1-indexed)
    static int pointQuery(int node, int start, int end, int idx) {
        if (start == end) return tree[node];
        pushDown(node);
        int mid = (start + end)/2;
        if (idx <= mid) return pointQuery(2 * node, start, mid, idx);
        else return pointQuery(2 * node + 1, mid +1, end, idx);
    }

    public static int[] solve(int[] pods, int[][]logs) {
        n = pods.length;
        tree = new int[4 * n];
        lazy = new int[4 * n];

        build(1, 1, n, pods);

        for (int[] log : logs) {
            int type = log[0];
            int param = log[1];
            int value = log[2];

            if (type == 1) {
                // Set pods[param] = value  (param is 1-indexed)
                pointUpdate(1, 1, n, param, value);
            } else if (type == 2) {
                // Raise all pods below value to value
                rangeRaise(1, 1, n, 1, n, value);
            }
        }

        // Read final values
        int[] result = new int[n];
        for (int i = 1; i <= n; i++) {
            result[i-1] = pointQuery(1, 1, n, i);
        }
        return result;
    }

    public static void main(String[] args) {
        // Example: pods = [2, 3, 4]
        // After [1, 3, 10] → [2, 3, 10]
        // After [2, -1, 8] → [8, 8, 10]
        int[] pods = {2, 3, 4};
        int[][] logs = {
                {1, 3, 10},   // set index 3 = 10
                {2, -1, 8}    // raise all < 8 to 8
        };

        int[] result = solve(pods, logs);
        System.out.println("Result: " + Arrays.toString(result));
        // Expected: [8, 8, 10]

        // More test cases
        int[] pods2 = {5, 1, 3, 7, 2};
        int[][] logs2 = {
                {2, -1, 4},   // raise all < 4 to 4  → [5,4,4,7,4]
                {1, 2, 10},   // set index 2 = 10     → [5,10,4,7,4]
                {2, -1, 6},   // raise all < 6 to 6  → [6,10,6,7,6]
        };
        System.out.println("Result2: " + Arrays.toString(solve(pods2, logs2)));
        // Expected: [6, 10, 6, 7, 6]
    }
}
