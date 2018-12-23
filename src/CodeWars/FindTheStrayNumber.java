package CodeWars;

import java.util.Arrays;

public class FindTheStrayNumber {

    public static void main(String[] args) {
        int[] array = new int[] {7, 2, 2, 2, 2, 2, 2};
        System.out.println(stray1(array));
        System.out.println(stray2(array));
        System.out.println(stray3(array));
    }

    static int stray1(int[] numbers) {
        int validNumber = 0;
        int invalidNumber = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i - 1] == 0) {
                validNumber = numbers[i];
                break;
            }
        }
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] - numbers[i - 1] != 0) {
                if (numbers[i] != validNumber) {
                    invalidNumber = numbers[i];
                } else {
                    invalidNumber = numbers[i - 1];
                }
                break;
            }
        }
        return invalidNumber;
    }

    static int stray2(int[] numbers) {
        if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) {
            return numbers[0];
        }
        for (int number : numbers) {
            if (number != numbers[0]) {
                return number;
            }
        }
        return 0;
    }

    static int stray3(int[] numbers) {
        return Arrays.stream(numbers).reduce(0, (a, b) -> a ^ b);
    }
}
