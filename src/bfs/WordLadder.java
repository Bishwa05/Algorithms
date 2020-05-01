package bfs;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordList){
            wordSet.add(word);
        }

        if(!wordSet.contains(endWord)){
            return 0;
        }

        HashSet<String> visited = new HashSet();
        visited.add(beginWord);

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        int level =1;
        while(!q.isEmpty()){
            int size = q.size();
            while(size>0) {
                String word = q.poll();

                char[] wordChars= word.toCharArray();
                for(int i=0; i<wordChars.length;  i++){
                    char originalChar = wordChars[i];
                    for(char c ='a'; c<='z'; c++){
                        if(wordChars[i]==c){
                            continue;
                        }
                        wordChars[i]=c;
                        String newWord = String.valueOf(wordChars);
                        if(endWord.equals(newWord)){
                            return level+1;
                        }
                        if(wordSet.contains(newWord)){
                            q.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    wordChars[i]= originalChar;
                }
                size--;
            }
            level++;
        }

        return 0;
    }

    public static void main(String arg[]){
//        List x = Arrays.asList("hot","dot","dog","lot","log");
//        String b = "hit";
//        String e = "cog";

        List x = Arrays.asList("ymann","yycrj","oecij","ymcnj","yzcrj","yycij","xecij","yecij","ymanj","yzcnj","ymain");
        String b = "ymain";
        String e = "oecij";
        WordLadder w  = new WordLadder();
        System.out.println(w.ladderLength(b,e,x));
    }

}
