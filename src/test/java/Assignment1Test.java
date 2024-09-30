import org.junit.Test;

import static org.junit.Assert.*;

public class Assignment1Test {

    // fibonacci(0) returns 0
    @Test
    public void test_fibonacci_zero() {
        int result = Assignment1.fibonacci(0);
        assertEquals(0, result);
    }

    // fibonacci(1) returns 1
    @Test
    public void test_fibonacci_one() {
        int result = Assignment1.fibonacci(1);
        assertEquals(1, result);
    }

    // fibonacci(-1) handles negative input gracefully
    @Test
    public void test_fibonacci_negative() {
        try {
            int result = Assignment1.fibonacci(-1);
            fail("Expected IllegalArgumentException for negative input");
        } catch (IllegalArgumentException e) {
            // Test passes
        }
    }

    // fibonacci("A") handles if user enters a letter instead of a number
    @Test
    public void test_handles_letter_input() {
        try {
            Assignment1.fibonacci(Integer.parseInt("A"));
            fail("Expected NumberFormatException for letter input");
        } catch (NumberFormatException e) {
            // Test passes
        }
    }

    // fibonacci(40) handles if user enters a large number
    @Test
    public void test_handles_large_number() {
        int result = Assignment1.fibonacci(40);
        assertEquals(102334155, result);
    }
}
