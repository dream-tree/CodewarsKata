import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheOddInt {
    public static void main(String[] args) {
        int[] sampleArray1 = new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5};   // 5
        System.out.println(findIt(sampleArray1));
        int[] sampleArray2 = new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1};   // 10
        System.out.println(findIt(sampleArray2));

        System.out.println(findIt2(sampleArray1));
        System.out.println(findIt2(sampleArray2));
    }

    public static int findIt(int[] a) {
        Arrays.sort(a);
        if (a.length == 1) {
            return a[0];
        }
        int counter = 1;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                counter++;
            } else {
                if (a.length - 1 == i) {    // if the last element is the correct answer
                    return a[i];
                } else if (counter % 2 != 0) {
                    return a[i - 1];
                } else {
                    counter = 1;
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int findIt2(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }
        for (Integer number : map.keySet()) {
            if (map.get(number) % 2 != 0) {
                return number;
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int findIt3(int[] a) {
        int xor = 0;
        for (int i = 0; i < a.length; i++) {
            xor ^= a[i];
        }
        return xor;
    }
}
