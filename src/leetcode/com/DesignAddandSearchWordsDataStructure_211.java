package leetcode.com;

import java.util.HashMap;
import java.util.Map;

public class DesignAddandSearchWordsDataStructure_211 {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    static class WordDictionary {

        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr = curr.children.get(c);
            }

            curr.endOfWord = true;
        }

        public boolean search(String word) {
            return dfs(0, root, word);
        }

        private boolean dfs(int i, TrieNode node, String word) {
            TrieNode curr = node;

            for(int j = i; j < word.length(); j++) {
                char c = word.charAt(j);
                if(c == '.') {
                    for(TrieNode child : curr.children.values()) {
                        if(dfs(j + 1, child, word)) {
                            return true;
                        }
                        return false;
                    }
                } else {
                    if(!curr.children.containsKey(c)) {
                        return false;
                    }
                    curr = curr.children.get(c);
                }

            }
            return curr.endOfWord;
        }
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("a");
        wordDictionary.addWord(".");
        System.out.println(wordDictionary.search("a."));
    }

}
