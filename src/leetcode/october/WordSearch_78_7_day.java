package leetcode.october;

public class WordSearch_78_7_day {
    //TC: O(m^2 * n^2)
    //SC: O(L) L = word.length
    public static void main(String[] args) {
        char[][] board = {{'A','B', 'C', 'E'},{'S', 'F', 'C', 'S'},{'A', 'D', 'E', 'E'}};
        String word = "ABFS";

        System.out.println(exist2(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack(board, i, j, word, new StringBuilder(), new boolean[board.length][board[0].length])) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack(char[][] board, int i, int j, String word, StringBuilder currWord, boolean[][] visited) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) {
            return false;
        } else if(word.length() == currWord.length()) {
            System.out.println(currWord.toString());
            return word.equals(currWord.toString());
        }

        boolean found = false;

        currWord.append(board[i][j]);
        visited[i][j] = true;

        found = backtrack(board, i + 1, j, word, currWord, visited) ||
                backtrack(board, i, j + 1, word, currWord, visited) ||
                backtrack(board, i - 1, j, word, currWord, visited) ||
                backtrack(board, i, j - 1, word, currWord, visited);
        currWord.setLength(currWord.length() - 1);
        visited[i][j] = false;

        return found;

    }

    private static boolean exist2(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(backtrack2(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean backtrack2(char[][] board, int i, int j, String word, int index) {
        if(index == word.length()) {
            System.out.println(word);
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] == '@' || index > word.length() || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '@';

        boolean found = backtrack2(board, i + 1, j, word, index + 1) ||
                backtrack2(board, i - 1, j, word, index + 1) ||
                backtrack2(board, i, j + 1, word, index + 1) ||
                backtrack2(board, i, j - 1, word, index + 1);

        board[i][j] = temp;

        return found;
    }
}
