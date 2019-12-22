package dsds;

/**
 *
 * People connect with each other in a social network. A connection between Person  and Person  is represented as . When two persons belonging to different communities connect, the net effect is the merger of both communities which  and  belongs to.
 *
 * At the beginning, there are  people representing  communities. Suppose person  and connected and later  and  connected, then ,, and  will belong to the same community.
 *
 * There are two type of queries:
 *
 *  communities containing person  and  merged (if they belong to different communities).
 *
 *  print the size of the community to which person  belongs.
 *
 * Input Format
 *
 * The first line of input will contain integers  and , i.e. the number of people and the number of queries.
 * The next  lines will contain the queries.
 *
 * Constraints :
 *
 *
 *
 * Output Format
 *
 * The output of the queries.
 *
 * Sample Input
 *
 * 3 6
 * Q 1
 * M 1 2
 * Q 2
 * M 2 3
 * Q 3
 * Q 2
 * Sample Output
 *
 * 1
 * 2
 * 3
 * 3
 * Explanation
 *
 * Initial size of each of the community is .
 *
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solutions {

    private static List <Map<Integer,Set<Integer>>>disjointSet = new ArrayList<Map<Integer,Set<Integer>>>();
    // public Solution(){
    //     disjointSet = new ArrayList<Map<Integer,Set<Integer>>>();
    // }

    public static void create_set(int element){
        Map<Integer,Set<Integer>> map = new HashMap<Integer,Set<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        set.add(element);
        map.put(element, set);
        disjointSet.add(map);
    }

    public static void union(int first, int second){
        int first_rep = find_set(first);
        int second_rep = find_set(second);

        Set<Integer> first_set= null;
        Set<Integer> second_set = null;

        for(int index=0; index<disjointSet.size(); index++){
            Map<Integer,Set<Integer>> map = disjointSet.get(index);
            if(map.containsKey(first_rep)){
                first_set = map.get(first_rep);
            }else if(map.containsKey(second_rep)){
                second_set = map.get(second_rep);
            }
        }

        if(first_set != null && second_set != null){
            first_set.addAll(second_set);
        }

        for(int index =0; index<disjointSet.size(); index++){
            Map<Integer,Set<Integer>> map = disjointSet.get(index);

            if(map.containsKey(first_rep)){
                map.put(first_rep, first_set);
            }else if(map.containsKey(second_rep)){
                map.remove(second_rep);
                disjointSet.remove(index);
            }
        }
    }

    public static int find_set(int element) {
        for(int index =0; index<disjointSet.size(); index++){
            Map<Integer,Set<Integer>> map = disjointSet.get(index);
            Set<Integer> keySet = map.keySet();
            for(int key : keySet){
                Set<Integer> set = map.get(key);
                if(set.contains(element)){
                    return key;
                }
            }
        }
        return -1;
    }

    public static int find_set_size(int element) {
        for(int index =0; index<disjointSet.size(); index++){
            Map<Integer,Set<Integer>> map = disjointSet.get(index);
            Set<Integer> keySet = map.keySet();
            for(int key : keySet){
                Set<Integer> set = map.get(key);
                if(set.contains(element)){
                    //return key;
                    return set.size();
                }
            }
        }
        return -1;
    }

    public int getNumberofDisjointSets()
    {
        return disjointSet.size();
    }



    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int queries = sc.nextInt();

        for(int i =1; i<=people ; i++){
            create_set(i);
        }

        for(int i =0; i< queries; i++){
            String q = sc.next();
            if( "Q".equals(q)){
                System.out.println(find_set_size(Integer.parseInt(sc.next())));
            }
            if( "M".equals(q)){
                union(Integer.parseInt(sc.next()),Integer.parseInt(sc.next()));
            }
        }
    }
}


