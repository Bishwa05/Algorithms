package bfs;

import java.util.*;

/**
 * Leetcode  126.
 * TODO Come back again here.
 *
 */
public class WordLadderII {

        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

            Map<String, List<String>> wordGroups = new HashMap<>();
            for (String word : wordList) {
                for (int i = 0; i < word.length(); i++) {
                    String wordGroup = word.substring(0, i) + "*" + word.substring(i + 1);
                    wordGroups.computeIfAbsent(wordGroup, wg -> new ArrayList<>()).add(word);
                }
            }

            Set<String> visitedWords = new HashSet<>();
            Map<String, Set<String>> previousWords = new HashMap<>();

            Queue<String> currentWordsQueue = new LinkedList<>();
            currentWordsQueue.add(beginWord);

            boolean foundEndWord = false;
            while (!foundEndWord && !currentWordsQueue.isEmpty()) {
                Queue<String> nextWordsQueue = new LinkedList<>();

                while (!currentWordsQueue.isEmpty()) {
                    String currentWord = currentWordsQueue.remove();

                    if (currentWord.equals(endWord)) {
                        foundEndWord = true;
                    }

                    for (int i = 0; i < currentWord.length(); i++) {
                        String currentWordGroup = currentWord.substring(0, i) + "*" + currentWord.substring(i + 1);

                        for (String nextWord : wordGroups.getOrDefault(currentWordGroup, Collections.emptyList())) {
                            if (!nextWord.equals(currentWord) && !visitedWords.contains(nextWord)) {

                                nextWordsQueue.add(nextWord);
                                previousWords.computeIfAbsent(nextWord, w -> new HashSet<>()).add(currentWord);

                                if (nextWord.equals(endWord)) {
                                    foundEndWord = true;
                                }
                            }
                        }
                    }
                }

                visitedWords.addAll(nextWordsQueue);
                currentWordsQueue = nextWordsQueue;
            }

            if (!foundEndWord) {
                return new ArrayList();
            }

            List<List<String>> ladders = new ArrayList<>();

            List<String> ladder = new ArrayList<>();
            ladder.add(endWord);

            buildLadders(beginWord, endWord, previousWords, ladder, ladders);

            return ladders;
    }

    /**
     * not successful in leetcode.
     */
    public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        for(String word: wordList){
            wordSet.add(word);
        }

        Map<String, Set<String>> previousWords = new HashMap<>();

        boolean foundEndWord = false;
        if(!wordSet.contains(endWord)){
            foundEndWord = false;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        while(!q.isEmpty()){
            int size = q.size();
            while(size>0) {
                String word = q.poll();

                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordChars.length; i++) {
                    char originalChar = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordChars[i] == c) {
                            continue;
                        }
                        wordChars[i] = c;
                        String newWord = String.valueOf(wordChars);

                        if (endWord.equals(newWord)) {
                            //previousWords.computeIfAbsent(word, w -> new HashSet<>()).add(newWord);
                            foundEndWord = true;
                        }

//                        if (wordSet.contains(newWord)) {
//                            q.offer(newWord);
//                            wordSet.remove(newWord);
//                            //System.out.println(newWord+"||"+word);
//                            previousWords.computeIfAbsent(newWord, w -> new HashSet<>()).add(word);
//
//                        }

                    }
                    wordChars[i] = originalChar;
                }
//                if(wordSet.isEmpty()){
//                    while(!q.isEmpty()){
//                        String x = q.poll();
//                        String y = q.poll();
//                        size  =0;
//                        previousWords.computeIfAbsent(y, w -> new HashSet<>()).add(x);
//                    }
//                }

                size--;
            }

        }

        if (!foundEndWord) {
            return new ArrayList();
        }

        List<List<String>> ladders = new ArrayList<>();

        List<String> ladder = new ArrayList<>();
        ladder.add(endWord);

        buildLadders(beginWord, endWord, previousWords, ladder, ladders);

        return ladders;

    }

    private void buildLadders(String beginWord, String currentWord, Map<String, Set<String>> previousWords, List<String> ladder, List<List<String>> ladders) {
        if (currentWord.equals(beginWord)) {
            ArrayList<String> reversedLadder = new ArrayList<>(ladder);
            Collections.reverse(reversedLadder);
            ladders.add(reversedLadder);
            return;
        }

        for (String previousWord : previousWords.get(currentWord)) {
            ladder.add(previousWord);

            buildLadders(beginWord, previousWord, previousWords, ladder, ladders);
            //buildLadders(previousWord, beginWord, previousWords, ladder, ladders);

            ladder.remove(previousWord);
        }
    }

    /**
     * Optimized approach as per leetcode.
     */
    public List<List<String>> findLadders3(String beginWord, String endWord, List<String> wordList){

            List<List<String>> res = new ArrayList<>();
            Set<String> words = new HashSet<>(wordList);

            if (!words.contains(endWord)) {
                return res;
            }

            Map<String, List<String>> mapTree = new HashMap<>();
            Set<String> begin = new HashSet<>();
            Set<String> end = new HashSet<>();

            begin.add(beginWord);
            end.add(endWord);
            if (buildTree(words, begin, end, mapTree, true)) {
                dfs(res, mapTree, beginWord, endWord, new LinkedList<>());
            }
            return res;
        }


        private boolean buildTree(Set<String> words, Set<String> begin, Set<String> end, Map<String, List<String>> mapTree, boolean isFront) {
            if (begin.size() == 0) return false;

            if (begin.size() > end.size()) {
                return buildTree(words, end, begin, mapTree, !isFront);
            }

            words.removeAll(begin);
            boolean isMeet = false;
            Set<String> nextLevel = new HashSet<>();
            for (String word : begin) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char old = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String str = String.valueOf(chars);
                        if (words.contains(str)) {
                            nextLevel.add(str);
                            String key = isFront ? word : str;
                            String nextWord = isFront ? str : word;
                            if (end.contains(str)) {
                                isMeet = true;
                            }
                            mapTree.putIfAbsent(key, new ArrayList<>());
                            mapTree.get(key).add(nextWord);
                        }
                    }
                    chars[i] = old;
                }
            }
            if (isMeet) return true;
            return buildTree(words, nextLevel, end, mapTree, isFront);
        }

        private void dfs(List<List<String>> res, Map<String, List<String>> mapTree, String beginWord, String endWord, LinkedList<String> list) {
            list.add(beginWord);
            if (beginWord.equals(endWord)) {
                res.add(new ArrayList<>(list));
                list.removeLast();
                return;
            }
            if (mapTree.containsKey(beginWord)) {
                for (String word : mapTree.get(beginWord)) {
                    dfs(res, mapTree, word, endWord, list);
                }
            }
            list.removeLast();
        }

    public static void main(String arg[]){
        WordLadderII w = new WordLadderII();

//        List x = Arrays.asList("hot","dot","dog","lot","log");
//        String b = "hit";
//        String e = "cog";
        //List<List<String>> l = w.findLadders(b, e, x);



        String b ="hot";
        String e = "dog";
        List x = Arrays.asList("hot","dog","dot");

        List<List<String>> l = w.findLadders3(b, e, x);
        l.forEach(d-> {
            d.forEach(f ->  System.out.print(f+" "));
            System.out.println();
        }
        );

    }
}
