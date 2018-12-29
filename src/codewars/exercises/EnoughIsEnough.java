package codewars.exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnoughIsEnough {

    public static void main(String[] args) {
        int[] array = new int[] {1, 1, 3, 3, 7, 2, 2, 2};
        System.out.println(Arrays.toString(deleteNth(array, 1)));
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer value : elements) {
            int mapValue = map.getOrDefault(value, 0);
            if (mapValue < maxOccurrences) {
                map.put(value, mapValue + 1);
                list.add(value);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}