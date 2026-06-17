package trie;

import java.util.ArrayList;
import java.util.List;

/**
 * This was the question which made me exit from 3rd round in salesforce interview.
 */
public class AutoComplete {
    TrieNode root;
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isLeaf;
    }

    public AutoComplete() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (index > 26 || index < 0) continue;

            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isLeaf = true;
    }

    public List<String> getSuggestion(String word) {
        List<String> result = new ArrayList<>();
        TrieNode curr = root;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (index >= 26 || index < 0 || curr.children[index] == null) return result;
            curr = curr.children[index];
        }

        dfs(curr, word, result);

        return result;
    }

    private void dfs(TrieNode curr, String word, List<String> result) {
        if (curr.isLeaf) {
            result.add(word);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                char newChar = (char)('a'+ i);
                dfs(curr.children[i], word+newChar, result);
            }
        }
    }

    public static void main(String[] args) {
        AutoComplete a = new AutoComplete();
        a.insert("hello");
        a.insert("help");
        a.insert("held");
        a.insert("nohelp");

        a.getSuggestion("hel").forEach(e -> System.out.println(e));

    }
}
