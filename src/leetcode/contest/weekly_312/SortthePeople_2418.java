package leetcode.contest.weekly_312;

import java.util.Arrays;
import java.util.TreeMap;

/*
*
*
* */
public class SortthePeople_2418 {
  public static void main(String[] args) {
    System.out.println(Arrays.toString(sortPeople(new String[] {"Mary","John","Emma"}, new int[] {180,165,170})));
    System.out.println(Arrays.toString(sortPeople(new String[] {"Alice","Bob","Bob"}, new int[] {155,185,150})));
  }

  public static String[] sortPeople(String[] names, int[] heights) {
    TreeMap<Integer, String> map = new TreeMap<>();

    for(int i = 0; i < heights.length; i++) {
      map.put(-heights[i], names[i]);
    }

    String[] result = new String[names.length];

    int i = 0;
    for(String name : map.values()) {
      result[i++] = name;
    }

    return result;
  }
}
