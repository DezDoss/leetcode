package leetcode.com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindRootOfNaryTree_1506 {

    
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    };


    class Solution {
        public Node findRoot(List<Node> tree) {
            Set<Integer> seen = new HashSet<>();
            for(Node node : tree) {
                for(Node child : node.children) {
                    seen.add(child.val);
                }
            }

            for(Node node : tree) {
                if(!seen.contains(node.val)) {
                    return node;
                }
            }

            return null;
        }
    }
}
