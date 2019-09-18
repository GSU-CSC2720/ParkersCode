package lab1;

import java.util.HashMap;

public class Fib {
    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            long n = fib(i, new HashMap<Long, Long>());
            System.out.println(n);
        }
    }

    private static long fib2(long n, HashMap<Long, Long> memo) {
        if (n < 2) {memo.put(n, n);
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, fib(n - 1, memo) + fib(n - 2, memo));
        return memo.get(n);
    }
    
    

}
 