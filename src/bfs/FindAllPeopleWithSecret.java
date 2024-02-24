package bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * https://leetcode.com/problems/find-all-people-with-secret/description/?envType=daily-question&envId=2024-02-24
 *
 *
 * You are given an integer n indicating there are n people numbered from 0 to n - 1. You are also given a 0-indexed 2D integer array meetings where meetings[i] = [xi, yi, timei] indicates that person xi and person yi have a meeting at timei. A person may attend multiple meetings at the same time. Finally, you are given an integer firstPerson.
 *
 * Person 0 has a secret and initially shares the secret with a person firstPerson at time 0. This secret is then shared every time a meeting takes place with a person that has the secret. More formally, for every meeting, if a person xi has the secret at timei, then they will share the secret with person yi, and vice versa.
 *
 * The secrets are shared instantaneously. That is, a person may receive the secret and share it with people in other meetings within the same time frame.
 *
 * Return a list of all the people that have the secret after all the meetings have taken place. You may return the answer in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 6, meetings = [[1,2,5],[2,3,8],[1,5,10]], firstPerson = 1
 * Output: [0,1,2,3,5]
 * Explanation:
 * At time 0, person 0 shares the secret with person 1.
 * At time 5, person 1 shares the secret with person 2.
 * At time 8, person 2 shares the secret with person 3.
 * At time 10, person 1 shares the secret with person 5.​​​​
 * Thus, people 0, 1, 2, 3, and 5 know the secret after all the meetings.
 *
 * Example 2:
 *
 * Input: n = 4, meetings = [[3,1,3],[1,2,2],[0,3,3]], firstPerson = 3
 * Output: [0,1,3]
 * Explanation:
 * At time 0, person 0 shares the secret with person 3.
 * At time 2, neither person 1 nor person 2 know the secret.
 * At time 3, person 3 shares the secret with person 0 and person 1.
 * Thus, people 0, 1, and 3 know the secret after all the meetings.
 *
 * Example 3:
 *
 * Input: n = 5, meetings = [[3,4,2],[1,2,1],[2,3,1]], firstPerson = 1
 * Output: [0,1,2,3,4]
 * Explanation:
 * At time 0, person 0 shares the secret with person 1.
 * At time 1, person 1 shares the secret with person 2, and person 2 shares the secret with person 3.
 * Note that person 2 can share the secret at the same time as receiving it.
 * At time 2, person 3 shares the secret with person 4.
 * Thus, people 0, 1, 2, 3, and 4 know the secret after all the meetings.
 *
 */
public class FindAllPeopleWithSecret {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<List<List<Integer>>> list=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            list.add(new ArrayList<>());
        }

        for(int i=0;i<meetings.length;i++)
        {
            int u=meetings[i][0];
            int v=meetings[i][1];
            int t=meetings[i][2];

            list.get(u).add(Arrays.asList(v,t));
            list.get(v).add(Arrays.asList(u,t));
        }

        int visited[]=new int[n];
        Queue<int []> queue=new PriorityQueue<>((a, b)->a[1]-b[1]);
        queue.add(new int[]{firstPerson,0});
        queue.add(new int[]{0,0});

        while(!queue.isEmpty())
        {
            int arr[]=queue.poll();
            int node=arr[0];
            int time=arr[1];
            if(visited[node]==1)
            {
                continue;
            }
            ans.add(node);
            visited[node]=1;

            for(List<Integer> l : list.get(node))
            {
                int num=l.get(0);
                int t=l.get(1);

                if((visited[num]==0) && (t>=time))
                {
                    queue.add(new int[]{num,t});
                }
            }
        }

        // Collections.sort(ans);
        return ans;
    }
}
