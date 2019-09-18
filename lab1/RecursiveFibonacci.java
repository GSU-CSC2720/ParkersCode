package lab1;


/**
 * A class holding different recursive methods to compute Fibonacci numbers.
 * 0, 1, 1, 2, 3, 5, 8, ...
 * 
 */
public class RecursiveFibonacci
{


    /**
     * basic - The simple version of Fibonacci.
     * 
     * @param  n   A positive integer. 
     * @return     The nth Fibonacci number.
     */
    public long basic(long n)
    {
        long result = 1;
        
        if( n <= 0)
            result = 0;
        else if (n == 1)
            result = 1;
        else
            result = basic(n-1) + basic(n-2);
        
        return result;
    }
    


    


    
    
}

