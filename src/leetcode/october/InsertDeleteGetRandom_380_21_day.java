package leetcode.october;

import java.util.*;

public class InsertDeleteGetRandom_380_21_day {

    static class RandomizedSet {
        Map<Integer, Integer> map;
        List<Integer> list;
        Random random;
        public RandomizedSet() {
            map = new HashMap<>();
            list = new ArrayList<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
         }

        public boolean remove(int val) {
            if(!map.containsKey(val)) return false;
            int index = map.get(val);
            int element = list.get(list.size() - 1);
            map.put(element, index);
            list.set(index, element);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            return list.get(random.nextInt(list.size()));
        }
    }
}
