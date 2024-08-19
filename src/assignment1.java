public class assignment1 {
    public static void main(String[] args) {
        System.out.println(fibonacciString(10));
    }// end of main

    /**
     * Calculates the nth number in the Fibonacci sequence.
     *
     * @param n the position of the number in the Fibonacci sequence
     * @return the nth number in the Fibonacci sequence
     */
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }// end of fibonacci

    /**
     * Returns a string describing the nth Fibonacci number.
     *
     * @param n the position of the number in the Fibonacci sequence
     * @return a string containing the position and value of the nth Fibonacci number
     */
    public static String fibonacciString(int n) {
        return "The " + n + "th number in the  Fibonacci sequence is " + fibonacci(n);
    }// end of fibonacciString

}// end of class


