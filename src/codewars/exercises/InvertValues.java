
import java.util.Arrays;

public class InvertValues {
    public static void main(String[] args) {
        int[] input = new int[] {-1,-2,-3,-4,-5};
        int[] input2 = new int[0];

        System.out.println(Arrays.toString(input));
        System.out.println(Arrays.toString(invert(input)));
        System.out.println(Arrays.toString(invert(input2)));
    }

    public static int[] invert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
        return array;
    }
}
