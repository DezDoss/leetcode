package leetcode.com;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;

public class AverageHeightOfBuildingsInEachSegment_2015 {
    public static int[][] averageHeightOfBuildings(int[][] buildings) {
        // [x, delta_height]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        for (int[] bldg : buildings) {
            pq.offer(new int[] {bldg[0], bldg[2]});
            pq.offer(new int[] {bldg[1], -bldg[2]});
        }

        ArrayDeque<int[]> result = new ArrayDeque<>();
        int start = 0;
        int sum = 0;
        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] event = pq.poll();
            if (cnt != 0 && event[0] != start) {
                int h = sum / cnt;
                if (!result.isEmpty() && result.peekLast()[1] == start && result.peekLast()[2] == h) {
                    result.peekLast()[1] = event[0];
                    result.peekLast()[2] = h;
                } else {
                    result.offerLast(new int[] {start, event[0], h});
                }
            }
            start = event[0];
            sum += event[1];
            cnt += event[1] > 0 ? 1 : -1;
        }

        int[][] res = new int[result.size()][];
        for (int i = 0; i < res.length; ++i) {
            res[i] = result.pollFirst();
        }
        return res;
    }

    public static void main(String[] args) {
//        [[1,3,2],[2,5,3],[2,8,3]]
        int[][] buildings = {{1, 3, 2}, {2, 5, 3}, {2, 8, 3}};
        int[][] result = averageHeightOfBuildings(buildings);
        for(int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }
}
