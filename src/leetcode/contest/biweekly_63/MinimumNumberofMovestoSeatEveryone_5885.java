package leetcode.contest.biweekly_63;

import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone_5885 {
    public int minMovesToSeat(int[] seats, int[] students) {
        int count = 0;
        Arrays.sort(seats);
        Arrays.sort(students);

        for(int i = 0; i <seats.length; i++) {
            count += Math.abs(seats[i] - students[i]);
        }

        return count;
    }
}
