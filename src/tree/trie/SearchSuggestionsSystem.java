package tree.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode 1268. Search Suggestions System
 * https://leetcode.com/problems/search-suggestions-system/
 */
public class SearchSuggestionsSystem {
    class Trie {
        class Node {
            boolean isWord = false;
            List<Node> children = Arrays.asList(new Node[26]);
        };
        Node Root, curr;
        List<String> resultBuffer;

        void dfsWithPrefix(Node curr, String word) {
            if(resultBuffer.size() ==3) return;

            if (curr.isWord) resultBuffer.add(word);

            for (char c = 'a'; c<='z'; c++) {
                if (curr.children.get(c-'a') != null)
                    dfsWithPrefix(curr.children.get(c-'a'), word+c);
            }
        }

        Trie() {
            Root = new Node();
        }

        void insert(String s) {
            curr = Root;
            for(char c : s.toCharArray()) {
                if (curr.children.get(c-'a') == null)
                    curr.children.set(c-'a', new Node());
                curr = curr.children.get(c-'a');
            }
            curr.isWord = true;
        }

        List<String> getWordsStartingWith(String prefix) {
            curr = Root;
            resultBuffer = new ArrayList<String>();

            for(char c : prefix.toCharArray()) {
                if(curr.children.get(c-'a')== null){
                    return resultBuffer;
                }
                curr = curr.children.get(c-'a');
            }
            dfsWithPrefix(curr, prefix);
            return resultBuffer;
        }
    };

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        List<List<String>> result = new ArrayList<>();
        for(String w : products)
            trie.insert(w);
        String prefix = new String();
        for (char c : searchWord.toCharArray()) {
            prefix +=c;
            result.add(trie.getWordsStartingWith(prefix));
        }
        return result;
    }

    public static void main(String arg[]) {
        SearchSuggestionsSystem s = new SearchSuggestionsSystem();
        String[] dict = {"mobile","mouse","moneypot","monitor","mousepad"};
        String word = "mouse";
        List<List<String>> res = s.suggestedProducts(dict, word);
        res.forEach(e -> {
            e.forEach(y -> System.out.print(y+","));
            System.out.println("#");
        }
        );
    }

}
