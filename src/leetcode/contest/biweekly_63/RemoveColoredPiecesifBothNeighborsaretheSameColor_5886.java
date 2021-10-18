package leetcode.contest.biweekly_63;

public class RemoveColoredPiecesifBothNeighborsaretheSameColor_5886 {
    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;

        for(int i = 0; i < colors.length(); i++) {
            if(i > 0 && i < colors.length() - 1) {
                if(colors.charAt(i) == 'A' && colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                    alice++;
                } else if(colors.charAt(i) == 'B' && colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                    bob++;
                }
            }
        }

        return alice > bob;
    }
}
