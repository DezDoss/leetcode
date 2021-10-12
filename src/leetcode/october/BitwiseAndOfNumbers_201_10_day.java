package leetcode.october;

public class BitwiseAndOfNumbers_201_10_day {

    public static void main(String[] args) {

    }

    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        while(left != right) {
            left = left >> 1;
            right = right >> 1;
            count++;
        }
        return left << count;
    }
}
