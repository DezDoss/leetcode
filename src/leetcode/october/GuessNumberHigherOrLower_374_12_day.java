package leetcode.october;

public class GuessNumberHigherOrLower_374_12_day {

    public int guessNumber(int n) {
        int left = 1, right = n;
        while(left < right) {
            int mid = left + (right - left) / 2;
            int guessedNumber = guess(mid);

            if(guessedNumber == 0) {
                return mid;
            } else if(guessedNumber == 1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }
}
