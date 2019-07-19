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

public class GiveMeADiamond {
    public static void main(String[] args) {
        System.out.println(print(9));
    }

    public static String print(int n) {
        if (n <= 0 || n % 2 == 0) {
            return null;
        }
        String diamond = "";
        diamond = buildUpperPartOfDiamod(n, diamond);
        diamond = buildLowerPartOfDiamond(n, diamond);
        return diamond;
    }

    // StringBuilder should be used
    private static String buildLowerPartOfDiamond(int n, String diamond) {
        int countLowerLines = n / 2;   // (with middle line)   // increment
        int countLowerLinesSpaces = 1;
        int countLowerLinesAsterices = n - 2;

        // for 7 lines total: 1st line has 4 signs (n/2 + 1), 2nd line has 5 signs ... middle line has 7 (n) signs; increment
        // for 7 lines total: 1st line has 3 spaces (n/2), 2nd line has 2 spaces (n/2 - 1)

        for (int i = countLowerLines + 1; i < n; i++) {   // number of lines
            int tempCountSpaces = countLowerLinesSpaces;
            int tempCountAsterices = countLowerLinesAsterices;
            while (tempCountSpaces > 0) {
                diamond += " ";
                tempCountSpaces--;
            }
            while (tempCountAsterices > 0) {
                diamond += "*";
                tempCountAsterices--;
            }
            countLowerLinesSpaces += 1;
            countLowerLinesAsterices -= 2;
            diamond += "\n";
        }
        return diamond;
    }

    private static String buildUpperPartOfDiamod(int n, String diamond) {
        int countUpperLines = n / 2;         // (with middle line)   // increment
        int countUpperLinesSpaces = n / 2;   // decrement
        int countUpperLinesAsterices = 1;

        for (int i = countUpperLines; i < n; i++) {   // number of upper lines + middle line
                int tempCountSpaces = countUpperLinesSpaces;
                int tempCountAsterices = countUpperLinesAsterices;
                while (tempCountSpaces > 0) {
                    diamond += " ";
                    tempCountSpaces--;
                }
                while (tempCountAsterices > 0) {
                   diamond += "*";
                   tempCountAsterices--;
                }
                countUpperLinesSpaces--;
                countUpperLinesAsterices+=2;
            diamond += "\n";
        }
        return diamond;
    }
}
