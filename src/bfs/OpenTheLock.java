package bfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 *
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 *
 *
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 *
 *
 */
public class OpenTheLock {

    public int openLock(String []deadends, String target) {
        HashSet<String> deadEnds = new HashSet<>(Arrays.asList(deadends));

        HashSet<String> visited = new HashSet<>();
        visited.add("0000");

        Queue<String> q = new LinkedList();
        q.offer("0000");

        int level =0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size > 0) {
                String lockPosition = q.poll();
                if(deadEnds.contains(lockPosition)){
                    size--;
                    continue;
                }

                if(lockPosition.equals(target)){
                    return level;
                }

                StringBuilder sb = new StringBuilder(lockPosition);

                for(int i=0; i<4; i++){
                    char currPos = sb.charAt(i);
                    String s1 = sb.substring(0, i) + (currPos=='9'?0: currPos -'0'+1)+
                            sb.substring(i+1);

                    String s2 = sb.substring(0, i) + (currPos=='0'?9: currPos -'0'-1)+
                            sb.substring(i+1);

                    if(!visited.contains(s1) && !deadEnds.contains(s1)){
                        q.offer(s1);
                        visited.add(s1);
                    }

                    if(!visited.contains(s2) && !deadEnds.contains(s2)){
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;

        }

    return -1;

    }

    public static void main(String arg[]){
        String arr[] ={"0201","0101","0102","1212","2002"};
        String target ="0202";
        OpenTheLock  o = new OpenTheLock();
        System.out.println(o.openLock(arr, target));
    }
}
