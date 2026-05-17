package bfs;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {
    public boolean canReach(int[] arr, int start) {

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(start);

        while (!q.isEmpty()) {
            int pos = q.poll();

            if(arr[pos] == 0) return true;

            int forward = pos + arr[pos];
            int backward = pos - arr[pos];
            if (forward < arr.length && !visited[forward]) {
                q.offer(forward);
                visited[forward] = true;
            }
            if (backward >=0 && !visited[backward]) {
                q.offer(backward);
                visited[backward] = true;
            }
        }

        return false;

    }

    public static void main(String[] args) {
        //int[] arr = new int[] {4,2,3,0,3,1,2};
        int[] arr = new int[] {1,1,1,1,1,1,1,1,0};
        JumpGameIII j = new JumpGameIII();
        System.out.println(j.canReach(arr, 3));
    }
}
