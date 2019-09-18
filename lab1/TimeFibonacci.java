package lab1;

import java.util.*;
import java.io.*;    

/**
 * Time how long it takes to compute Fibonacci numbers.
 * 
 */

    
public class TimeFibonacci
{
    
    public static void main(String args[])
    {
        /*
        System.out.println("What is the value of n?");
        int n = getInt("Please enter an integer value greater than or equal to 0");
        
        timeBasic(n);
        */
        timeBasic(42);
        
    }
 
    
    
    public static void timeBasic(int n)
    {
        RecursiveFibonacci fibonacci = new RecursiveFibonacci();
        long result;
        System.out.println("TIMING BASIC RECURSIVE FIBONACCI");
        
        Calendar start = Calendar.getInstance();
        result = fibonacci.basic(n);
        Calendar end = Calendar.getInstance();
        long diff = end.getTime().getTime() - start.getTime().getTime();
        
        System.out.println("Time to compute fibonacci(" + n + ") using basic recursion was " 
            + diff + " milliseconds.");
    }




    /**
     * Get an integer value
     *
     * @return     An integer.
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }
}
