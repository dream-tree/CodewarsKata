package codewars.exercises;

public class Scramblies {

    public static void main(String[] args) {
        boolean anagrammable = Scramblies.scramble("rkqodlw", "world");
        System.out.println(anagrammable);
    }

    public static boolean scramble(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return false;
        }
        int[] letters = new int[26];
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i) - 97]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char letter = str2.charAt(i);
            letters[letter - 97]--;
            if (letters[letter - 97] < 0) {
                return false;
            }
        }
        return true;
    }
}