package codewars.exercises;

public class CountTheDigit {

    private static int result;
       
    public static void main(String[] args) {
        CountTheDigit.nbDig(10, 1);
        CountTheDigit.nbDig(25, 1);
        CountTheDigit.nbDig(5750, 0);
        CountTheDigit.nbDig(11011, 2);
        CountTheDigit.nbDig(12224, 8);
        CountTheDigit.nbDig(11549, 1);        
    }
    
    public static int nbDig(int n, int d) {
        result = 0;
        int squaredNumber = 0;
        for (int i = 0; i <= n; i++) {
            squaredNumber = i * i;
            count(squaredNumber, d);
        }    
        return result;
    }
    
    public static void count(int currentSquaredNumber, int desiredDigit) {
        int currentSquaredNumberLength =
                Integer.toString(currentSquaredNumber).length();
        while (currentSquaredNumberLength > 0) {
            int lastDigit = currentSquaredNumber % 10;
            if (lastDigit == desiredDigit) {
                result++;
            }
            currentSquaredNumber /= 10;
            currentSquaredNumberLength--;
        }     
    }   
}
