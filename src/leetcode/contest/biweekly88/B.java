package leetcode.contest.biweekly88;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class B {
  public static void main(String[] args) {
    LUPrefix luPrefix = new LUPrefix(10);
    System.out.println(luPrefix.longest());
    luPrefix.upload(6);
    System.out.println(luPrefix.longest());
    luPrefix.upload(10);
    luPrefix.upload(7);
    luPrefix.upload(4);
    System.out.println(luPrefix.longest());
    luPrefix.upload(2);
    System.out.println(luPrefix.longest());
    luPrefix.upload(8);
    luPrefix.upload(3);
    luPrefix.upload(1);
    System.out.println(luPrefix.longest());
  }
}

class LUPrefix {
  Set<Integer> set;
  List<Integer> list;
  public LUPrefix(int n) {
    set = new HashSet<>();
    list = new ArrayList<>();
  }

  public void upload(int video) {
    set.add(video);
    if(video == 1) {
      list.add(video);
      while(set.contains(++video)) {
        list.add(video);
      }
    } else if(list.size() > 0 && list.get(list.size() - 1) == video - 1) {
      while(set.contains(video)) {
        list.add(video++);
      }
    }
  }

  public int longest() {
    return list.size();
  }
}