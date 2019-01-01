package codewars.exercises;

public class ReverseOrRotate {

    private static String resultString;

    public static void main(String[] args) {
    }

    public static String revRot(String stringForChunking, int requiredChunkSize) {
        resultString = "";
        if (stringForChunking.isEmpty() || requiredChunkSize <= 0) {
            return resultString;
        }
        int sizeOfStringForChunking = stringForChunking.length();
        if (requiredChunkSize > sizeOfStringForChunking) {
            return resultString;
        }
        int incompleteLastChunk = sizeOfStringForChunking % requiredChunkSize;
        stringForChunking = stringForChunking.substring(
                0, sizeOfStringForChunking - incompleteLastChunk);
        for (int i = 0; i < stringForChunking.length(); i += requiredChunkSize) {
            String chunkedStringOfDigits =
                    stringForChunking.substring(i, i + requiredChunkSize);
            countSumOfCubes(chunkedStringOfDigits, requiredChunkSize);
        }
        return resultString;
    }

    public static void countSumOfCubes(String chunkedStringOfDigits, int sz) {
        int sumOfCubes = 0;
        for (int i = 0; i < sz; i++) {
            int digit = Integer.parseInt(String.valueOf(
                    chunkedStringOfDigits.charAt(i)));
            sumOfCubes += digit * digit;
        }
        checkIfSumOfCubesIsEven(sumOfCubes, chunkedStringOfDigits);
    }

    public static void checkIfSumOfCubesIsEven(
            int sumOfCubes, String chunkedStringOfDigits) {
        if (sumOfCubes % 2 == 0) {
            resultString = resultString + reverseChunk(chunkedStringOfDigits);
        } else {
            resultString = resultString + rotateChunk(chunkedStringOfDigits);
        }
    }

    public static String reverseChunk(String chunked) {
        StringBuilder reversedChunk = new StringBuilder();
        for (int i = chunked.length() - 1; i >= 0; i--) {
            reversedChunk.append(chunked.charAt(i));
        }
        return reversedChunk.toString();
    }

    public static String rotateChunk(String chunkedString) {
        String rotatedChunk = chunkedString.substring(1);
        rotatedChunk = rotatedChunk + chunkedString.substring(0, 1);
        return rotatedChunk;
    }
}
