package leetcode.october.utils;

import java.util.HashMap;
import java.util.Map;

public class PrefixTrie2_1804 {
    static class TrieNode {
        Map<Character, TrieNode> children;
        int count;
        int totalWord;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
            count = 0;
            totalWord = 0;
            endOfWord = false;
        }
    }

    static class Trie {

        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;

            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    curr.children.put(c, new TrieNode());
                }
                curr.count++;
                curr = curr.children.get(c);
            }

            curr.totalWord++;
            curr.endOfWord = true;
        }

        public int countWordsEqualTo(String word) {
            TrieNode curr = root;

            for(char c : word.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    return 0;
                }
                curr = curr.children.get(c);
            }

            return curr.totalWord;
        }

        public int countWordsStartingWith(String prefix) {
            TrieNode curr = root;

            for(char c : prefix.toCharArray()) {
                if(!curr.children.containsKey(c)) {
                    return 0;
                }
                curr = curr.children.get(c);
            }

            return curr.count;
        }

        public void erase(String word) {
            TrieNode curr = root;

            for(char c : word.toCharArray()) {
                if(curr.children.containsKey(c)) {
                    curr.children.get(c).count--;
                }
                curr = curr.children.get(c);
            }

            curr.totalWord--;
        }
    }

    public static void main(String[] args) {

        Trie obj = new Trie();
        obj.insert("apple");
        obj.insert("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
        System.out.println(obj.countWordsStartingWith("app"));
        obj.erase("apple");
        System.out.println(obj.countWordsEqualTo("apple"));
        System.out.println(obj.countWordsStartingWith("app"));
        obj.erase("apple");                // Erases "apple". Now the trie is empty.
        System.out.println(obj.countWordsStartingWith("app"));

    }
}
