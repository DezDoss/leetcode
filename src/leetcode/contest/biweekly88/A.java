package leetcode.contest.biweekly88;

import java.util.HashMap;
import java.util.Map;

public class A {
  public static void main(String[] args) {
    System.out.println(equalFrequency("bac"));
  }

  public static boolean equalFrequency(String word) {
    for(int i = 0; i < word.length(); i++) {
      if(check(word.substring(0, i) + word.substring(i + 1))) {
        return true;
      }
    }

    return false;
  }

  private static boolean check(String word) {
    Map<Character, Integer> freq = new HashMap<>();
    for(char c : word.toCharArray()) {
      freq.put(c, freq.getOrDefault(c, 0) + 1);
    }

    int count = freq.get(word.charAt(0));

    for(int val : freq.values()) {
      if(val != count) {
        return false;
      }
    }

    return true;
  }
}
