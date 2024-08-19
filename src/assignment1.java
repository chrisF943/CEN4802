public class assignment1 {
    public static void main(String[] args) {
        System.out.println(fibonacciString(10));
    }// end of main


    /**
     * Returns the nth Fibonacci number.
     *
     * @param n an integer specifying the position of the desired Fibonacci number in the sequence
     * @return the nth Fibonacci number
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
     * Returns a string describing the nth Fibonacci number in the sequence.
     *
     * @param n an integer specifying the position of the desired Fibonacci number in the sequence
     * @return a string describing the nth Fibonacci number
     */
    public static String fibonacciString(int n) {
        return "The " + n + "th number in the  Fibonacci sequence is " + fibonacci(n);
    }// end of fibonacciString

}// end of class


