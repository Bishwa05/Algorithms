package heap;

import java.util.*;

/**
 * An election is happening in a college, where each vote will have priorities(1,2,3).
 * 1 vote of priority 3 > two votes of priority 1
 * Return the list of candidates based on decreasing order of total priorities from the votes.
 */
public class CandidateVote
{

    class Candidate {
        String name;
        int id;

        public Candidate (int id)
        {
            this.name = "";
            this.id = id;
        }

        public Candidate (String name, int id)
        {
            this.name = name;
            this.id = id;
        }
    }


    class CandiateVote {
        int candidateId;
        int pref;

        public CandiateVote (int candidateId, int pref)
        {
            this.candidateId = candidateId;
            this.pref = pref;
        }
    }

    public List<Candidate> decOrderVotes(List<CandiateVote> prefCandList) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> b[0]-a[0]);

        Map<Integer, Integer> map = new HashMap<>();

        for(CandiateVote pc : prefCandList){
            int val = 0;

            if(map.containsKey(pc.candidateId)){
                val =  pc.pref + map.get(pc.candidateId);
            } else{
                val = pc.pref;
            }
            map.put(pc.candidateId, val);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            int[] a = new int[2];
            a[1] = e.getKey();
            a[0] = e.getValue();
            pq.add(a);
        }


        // retrieve and populate a list

        List<Candidate> candidateList = new ArrayList<>();

        while(!pq.isEmpty()){
            int a[] = pq.poll();
            Candidate c = new Candidate(a[1]);
            candidateList.add(c);
        }

        return candidateList;
    }
}
