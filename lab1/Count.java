package lab1;

import java.util.*;

/**
 * A simple recursion for counting up.
 * 
 */
   
public class Count {
    public static void main(String args[]) {
        int n = getInt("Please enter an integer value greater than or equal to 0"); 
        System.out.println("Should count up from 1");
        countUp(n);
    }
    
    /**
     * countUp - A recursive function that counts up from 1 to n.
     * @param n The integer value to count up to. 
     */
    private static void countUp(int n) {
        if (n > 0) {
            countUp(n-1);
            System.out.println(n);
        }
    }
   
    /**
     * Get an integer value
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt) {
        Scanner input;
        int result = 10;        //default value is 10
        try {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();   
        } catch(NumberFormatException e) {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        } catch(Exception e) {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;                            
    }
}
