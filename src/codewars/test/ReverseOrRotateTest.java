package codewars.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import codewars.exercises.ReverseOrRotate;

class ReverseOrRotateTest {

    @Test
    public void shouldReturnReversedOrRotatedString1 () {
        assertEquals(ReverseOrRotate.reverseOrRotate("1234", 5), "");
    }

    @Test
    public void shouldReturnReversedOrRotatedString2() {
        assertEquals(ReverseOrRotate.reverseOrRotate("1234", 0), "");
    }

    @Test
    public void shouldReturnReversedOrRotatedString3() {
        assertEquals(ReverseOrRotate.reverseOrRotate("", 0), "");
    }

    @Test
    public void shouldReturnReversedOrRotatedString4() {
        String s = "733049910872815764";
        assertEquals(ReverseOrRotate.reverseOrRotate(s, 5), "330479108928157");
    }

    @Test
    public void shouldReturnReversedOrRotatedString5() {
        assertEquals(ReverseOrRotate.reverseOrRotate("66443875", 4), "44668753");
    }
}
