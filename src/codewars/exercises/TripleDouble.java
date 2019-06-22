package codewars.exercises;

public class TripleDouble {

    public static void main(String[] args) {
        int result = tripleDouble(451999277L, 41177722899L);
        System.out.println(result);
    }

    public static int tripleDouble(long num1, long num2) {
        String triples = String.valueOf(num1);
        String doubles = String.valueOf(num2);
        int[] digits = new int[10];

        for (int i = 1; i < triples.length() - 1; i++) {
            if (triples.charAt(i) == triples.charAt(i - 1)
                    && triples.charAt(i) == triples.charAt(i + 1)) {
                int index = triples.charAt(i) - 48;
                digits[index] = 1;
            }
        }
        for (int i = 1; i < doubles.length(); i++) {
            if (doubles.charAt(i) - doubles.charAt(i - 1) == 0) {
                int index = doubles.charAt(i) - 48;
                if (digits[index] == 1) {
                    return 1;
                }
            }
        }
        return 0;
    }
}
