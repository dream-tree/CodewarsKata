package codewars.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import codewars.exercises.CountTheDigit;

class CountTheDigitTest {

    @Test
    public void test() {
        assertEquals(CountTheDigit.nbDig(10, 1), 4);
        assertEquals(CountTheDigit.nbDig(25, 1), 11);
        assertEquals(CountTheDigit.nbDig(5750, 0), 4700);
        assertEquals(CountTheDigit.nbDig(11011, 2), 9481);
        assertEquals(CountTheDigit.nbDig(12224, 8), 7733);
        assertEquals(CountTheDigit.nbDig(11549, 1), 11905);
    }
}
