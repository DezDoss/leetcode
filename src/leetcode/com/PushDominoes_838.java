package leetcode.com;

import com.sun.javafx.tk.quantum.PrimaryTimer;

import java.util.Arrays;

public class PushDominoes_838 {

  public static void main(String[] args) {
    String str = ".L.R...LR..L..";
    System.out.println(pushDominoes(str));
  }

  public static String pushDominoes(String dominoes) {
    int n = dominoes.length();
    Pair[] left = new Pair[n];
    Pair[] right = new Pair[n];

    for(int i = 1; i < n; i++) {
      if(dominoes.charAt(i) == 'R') {
        left[i] = new Pair('R', 0);
      } else if(dominoes.charAt(i) == '.'
              && left[i - 1] != null && left[i - 1].c == 'R') {
        left[i] = new Pair('R', left[i - 1].priority + 1);
      }
     }
    for(int i = n - 2; i >= 0; i--) {
      if(dominoes.charAt(i) == 'L') {
        right[i] = new Pair('L', 0);
      } else if(dominoes.charAt(i) == '.'
             && right[i + 1] != null && right[i + 1].c == 'L') {
        right[i] = new Pair('L', right[i + 1].priority + 1);
      }
     }

    StringBuilder result = new StringBuilder();

    System.out.println(Arrays.toString(left));
    System.out.println(Arrays.toString(right));
    for(int i = 0; i < n; i++) {
      if(left[i] != null && right[i] != null) {
        if(left[i].priority < right[i].priority) {
          result.append(left[i].c);
        } else if(left[i].priority > right[i].priority) {
          result.append(right[i].c);
        } else {
          result.append('.');
        }
      } else if(left[i] != null) {
        result.append(left[i].c);
      } else if(right[i] != null) {
        result.append(right[i].c);
      } else {
        result.append('.');
      }
    }

    return result.toString();
  }

  static class Pair {
    char c;
    int priority;

    public Pair(char c, int priority) {
      this.c = c;
      this.priority = priority;
    }

    @Override
    public String toString() {
      return "Pair{" +
              "c=" + this.c +
              ", priority=" + this.priority +
              '}';
    }
  }
}
