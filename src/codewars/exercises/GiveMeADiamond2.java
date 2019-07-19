// there should be only leading spaces, no trailing spaces:
// not this way:
//        NNN*NNN
//        NN***NN
//        N*****N
//        *******
//        N*****N
//        NN***NN
//        NNN*NNN
// but this way:
//        NNN*
//        NN***
//        N*****
//        *******
//        N*****
//        NN***
//        NNN*
// other sample:
//        NN*
//        N***
//        *****
//        N***
//        NN*

public class GiveMeADiamond2 {
    public static void main(String[] args) {
        System.out.println(print(9));
    }

    public static String print(int n) {
        if (n <= 0 || n % 2 == 0) {
            return null;
        }

        StringBuilder diamond = new StringBuilder();
        buildUpperPartOfDiamond(n, diamond);
        buildLowerPartOfDiamond(n, diamond);
        return diamond.toString();
    }

    private static StringBuilder buildLowerPartOfDiamond(int n, StringBuilder diamond) {
        int countLowerLines = n / 2;   // (with middle line)   // increment
        int countLowerLinesSpaces = 1;
        int countLowerLinesAsterisks = n - 2;

        // for 7 lines total: 1st line has 4 signs (n/2 + 1), 2nd line has 5 signs ... middle line has 7 (n) signs; increment
        // for 7 lines total: 1st line has 3 spaces (n/2), 2nd line has 2 spaces (n/2 - 1)

        for (int i = countLowerLines + 1; i < n; i++) {   // number of lines
            int tempCountSpaces = countLowerLinesSpaces;
            int tempCountAsterisks = countLowerLinesAsterisks;
            while (tempCountSpaces > 0) {
                diamond.append(" ");
                tempCountSpaces--;
            }
            while (tempCountAsterisks > 0) {
                diamond.append("*");
                tempCountAsterisks--;
            }
            countLowerLinesSpaces += 1;
            countLowerLinesAsterisks -= 2;
            diamond.append("\n");
        }
        return diamond;
    }

    private static StringBuilder buildUpperPartOfDiamond(int n, StringBuilder diamond) {
        int countUpperLines = n / 2;         // (with middle line)   // increment
        int countUpperLinesSpaces = n / 2;   // decrement
        int countUpperLinesAsterisks = 1;

        for (int i = countUpperLines; i < n; i++) {   // number of upper lines + middle line
                int tempCountSpaces = countUpperLinesSpaces;
                int tempCountAsterisks = countUpperLinesAsterisks;
                while (tempCountSpaces > 0) {
                    diamond.append(" ");
                    tempCountSpaces--;
                }
                while (tempCountAsterisks > 0) {
                    diamond.append("*");
                   tempCountAsterisks--;
                }
                countUpperLinesSpaces--;
                countUpperLinesAsterisks+=2;
            diamond.append("\n");
        }
        return diamond;
    }
}
