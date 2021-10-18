package leetcode.patterns.parentheses;

public class MinimumAddtoMakeParenthesesValid_921 {

    public static void main(String[] args) {
        System.out.println((int) 'a');
    }

    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for(char c : s.toCharArray()) {
            if(c == ')') {
                right++;
                if(left > 0) {
                    right--;
                    left--;
                }
            } else {
                left++;
            }
        }

        return left + right;
    }
}
