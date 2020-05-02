package bfs;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Leetcode : 433
 *
 * Time complexity :
 */
public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {

        char[] geneCombination = {'A', 'C', 'G', 'T'};

        Set<String> bankSet = new HashSet<>();

        for(String x : bank){
            bankSet.add(x);
        }

        if(!bankSet.contains(end)){
            return -1;
        }

        Queue<String> queue = new ArrayDeque();
        queue.offer(start);
        int mutation =0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                String gene = queue.poll();

                char[] geneArray = gene.toCharArray();

                for(int i=0; i<geneArray.length; i++){
                    char originalChar = geneArray[i];
                    for(char c: geneCombination){
                        if(geneArray[i]==c){
                            continue;
                        }

                        geneArray[i] =c;
                        String newGene = String.valueOf(geneArray);

                        if(end.equals(newGene)){
                            return mutation+1;
                        }

                        if(bankSet.contains(newGene)){
                            queue.offer(newGene);
                            bankSet.remove(newGene);
                        }
                    }
                    geneArray[i]= originalChar;
                }

                size--;
            }

            mutation++;
        }
        return -1;
    }

    public static void main(String arg[]){

        MinimumGeneticMutation mg = new MinimumGeneticMutation();

//        String start = "AACCGGTT";
//        String end  = "AAACGGTA";
//        String []  strList = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};


//        String start = "AAAAACCC";
//        String end  = "AACCCCCC";
//        String []  strList = {"AAAACCCC", "AAACCCCC", "AACCCCCC"};

        String start = "AACCGGTT";
        String end  = "AACCGGTA";
        String []  strList = {"AACCGGTA"};

        System.out.println(mg.minMutation(start, end, strList));
    }
}
