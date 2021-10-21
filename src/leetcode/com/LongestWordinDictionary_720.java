package leetcode.com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class LongestWordinDictionary_720 {
    static TrieNode root;
    static String result = "";
    public static void main(String[] args) {
        String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
        System.out.println(longestWord(words));
    }

    static public String longestWord(String[] words) {
        root = new TrieNode();
        for(String word : words) {
            insert(word);
        }


        for(String word : words) {
            if(valid(word)) {
                if(result.length() < word.length() || (result.length() == word.length() && word.compareTo(result) < 0)) {
                    result = word;
                }
            }
        }

        return result;
    }

    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfWord;

        public TrieNode() {
            children = new HashMap<>();
        }
    }

    private static void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }

        curr.endOfWord = true;
    }

    private static boolean valid(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(!curr.children.containsKey(c)) return false;
            curr = curr.children.get(c);
            if(!curr.endOfWord) return false;
        }
        return true;
    }
}
