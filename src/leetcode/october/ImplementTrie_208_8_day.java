package leetcode.october;

import java.util.HashMap;
import java.util.Map;

public class ImplementTrie_208_8_day {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            endOfWord = false;
        }
    }

    static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
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
            TrieNode curr = root;

            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    return false;
                } else {
                    curr = curr.children.get(c);
                }
            }

            return curr.endOfWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;

            for(char c : prefix.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    return false;
                } else {
                    curr = curr.children.get(c);
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.insert("apple");
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
