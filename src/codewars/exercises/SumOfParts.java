import java.util.Arrays;

public class SumOfParts {
    public static void main(String[] args) {
        int[] numbersTosumUp = {0, 1, 3, 6, 10};
        System.out.println(Arrays.toString(sumParts(numbersTosumUp)));
        System.out.println(Arrays.toString(sumParts2(numbersTosumUp)));
    }

    public static int[] sumParts(int[] ls) {
        int[] sumsOfNumbers = new int[ls.length + 1];
        sumsOfNumbers[ls.length] = 0;
        int singleSum = 0;
        for (int i = ls.length + 1; i >= 2 ; i--) {
            singleSum += ls[i - 2];
            sumsOfNumbers[i - 2] = singleSum;
        }
        return sumsOfNumbers;
    }

    public static int[] sumParts2(int[] ls) {
        int[] sumsOfNumbers = new int[ls.length + 1];
        int singleSum = 0;
        for (int i = ls.length - 1; i >= 0 ; i--) {
            singleSum += ls[i];
            sumsOfNumbers[i] = singleSum;
        }
        return sumsOfNumbers;
    }
}

