public class Assignment1 {
    public static void main(String[] args) {
        System.out.println(fibonacciString(10));
    }// end of main


    /**
     * Returns the nth Fibonacci number.
     *
     * @param n an integer specifying the position of the desired Fibonacci number in the sequence
     * @return the nth Fibonacci number
     * @throws IllegalArgumentException if n is negative
     */
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Negative arguments are not allowed");
        }
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }// end of fibonacci


    /**
     * Returns a string describing the nth Fibonacci number in the sequence.
     *
     * @param n an integer specifying the position of the desired Fibonacci number in the sequence
     * @return a string describing the nth Fibonacci number
     */
    public static String fibonacciString(int n) {
        return "The " + n + "th number in the  Fibonacci sequence is " + fibonacci(n);
    }// end of fibonacciString
}
