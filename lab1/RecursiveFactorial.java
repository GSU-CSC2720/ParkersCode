package lab1;

public class RecursiveFactorial {
    /**
     * The basic recursive factorial. 
     * 
     * @param  n   The number to compute factorial of.
     * @return     n factorial.
     */
    public long basic(long n) {
        long result = 1;
        if (n > 1) result = n * basic(n-1);
        return result;
    }
    
    /**
     * The tail recursive version of factorial.
     * 
     * @param  n   The number to compute factorial of.
     * @return     n factorial.
     */
    public static long tailRecursive(long n) {
        return helper(n, 1);
    }

    /**
     * The tail recursive helper function for factorial. 
     * @param  n   The number to compute factorial of.
     * @param  partial   The partial result that is being built up.
     * @return     n factorial.
     */

    private static long helper(long n, long partial) {
        return n < 2 ? partial : helper(n-1, partial*n); 
    }



}

