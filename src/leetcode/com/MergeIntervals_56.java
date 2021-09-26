package leetcode.com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals_56 {
    //My solution
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] begin = intervals[0];
        for(int i = 1; i < intervals.length; i++) {

            if(begin[1] < intervals[i][0]) {
                intervalList.add(begin);
                begin = intervals[i];
            } else {
                begin[0] = Math.min(begin[0], intervals[i][0]);
                begin[1] = Math.max(begin[1], intervals[i][1]);
            }
        }

        if(intervalList.isEmpty() || intervalList.get(intervalList.size() - 1) != begin) {
            intervalList.add(begin);
        }

        int[][] result = new int[intervalList.size()][2];
        intervalList.toArray(result);

        return result;
    }

    //from discuss
    public int[][] merge2(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;

        // Sort by ascending starting point
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);
        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) // Overlapping intervals, move the end if needed
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            else {                             // Disjoint intervals, add the new interval to the list
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
