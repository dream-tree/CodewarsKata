package codewars.exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;;

public class HelpTheBookseller {

    public static void main(String[] args) {
        String[] L = {"ABART 20", "CDXEF 50", "BKWRK 25", "BTSQZ 89", "DRTYM 60"};
        String[] M = {"A", "C", "W", "B"};
        System.out.println(stockSummary(L, M));
    }

    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        Arrays.sort(lstOfArt);
        Map<String, Integer> map = new HashMap<>();
        for (String book : lstOfArt) {
            String[] x = book.split(" ");
            String categoryLetter = Character.toString(book.charAt(0));
            map.put(categoryLetter, map.getOrDefault(categoryLetter, 0)
                    + Integer.parseInt(x[1]));
            // map.put(categoryLetter, map.merge(categoryLetter,
            //     Integer.parseInt(x[1]), Integer::sum));
        }
        String result = "";
        for (String categoryLetter : lstOf1stLetter) {
            Integer amount = map.getOrDefault(categoryLetter, 0);
            result = result + "(" + categoryLetter + " : " + amount + ")";
        }
        result = result.replaceAll("\\)\\(", "\\) - \\(");
        return result;
    }
}
