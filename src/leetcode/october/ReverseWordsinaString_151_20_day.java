package leetcode.october;

public class ReverseWordsinaString_151_20_day {
    public static void main(String[] args) {
        System.out.println(reverseWords(new String("  hello world  ")));
    }

    private static String reverseWords(String s) {
        String[] words = reverse(s).split(" ");

        StringBuilder result = new StringBuilder();
        for(String word : words) {
            if(word.equals("")) continue;
            result.append(reverse(word)).append(" ");
        }

        if(result.length() > 0 && result.charAt(result.length() - 1) == ' ') {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    private static String reverse(String str) {
        char[] word = str.toCharArray();
        int i = 0, j = word.length - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }

        return new String(word);
    }
}
