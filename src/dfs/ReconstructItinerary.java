package dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode
 * 332. Reconstruct Itinerary
 *
 * All of the tickets belong to a man who departs from "JFK", thus, the itinerary must begin with "JFK". If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string.
 *
 *
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 *
 */
public class ReconstructItinerary
{
    public List<String> findItinerary(List<List<String>> tickets) {

        int n = tickets.size();

        int visited[] = new int[n];
        List<String> result = new ArrayList<>();
        result.add("JFK");
        visit("JFK",visited,tickets, result);
        return result;
    }

    // This does not handle duplicate // Sorted res now
    public void visit(String src, int[] visited, List<List<String>> tickets, List<String> result){
        //
        for(int i =0; i< tickets.size(); i++){

            if(visited[i] == 1){
                continue;
            }
            List<String> comb = tickets.get(i);
            System.out.println(i+ "- "+ comb.get(0));
            if(src.equals(comb.get(0))){
                visited[i] = 1;
                String dest = comb.get(1);
                result.add(dest);
                visit(dest, visited, tickets, result);
            }
        }
    }

    public static void main(String arg[]){
        ReconstructItinerary r = new ReconstructItinerary();
        List<List<String>> tickets = new ArrayList();
        List l1 = new ArrayList();
        l1.add("MUC");
        l1.add("LHR");
        tickets.add(l1);

        List l2 = new ArrayList();
        l2.add("JFK");
        l2.add("MUC");
        tickets.add(l2);

        List l3 = new ArrayList();
        l3.add("SFO");
        l3.add("SJC");
        tickets.add(l3);

        List l4 = new ArrayList();
        l4.add("LHR");
        l4.add("SFO");
        tickets.add(l4);

        r.findItinerary(tickets).forEach(e -> System.out.println(e));

    }

}
