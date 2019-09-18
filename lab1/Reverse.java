package lab1;

import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        List<Integer> xs = new ArrayList<Integer>();
        for (int i = 0; i < 10; i++) xs.add(i);
        show(xs);
        List<Integer> rev = reverse(xs);
        show(rev);
    }
    
    public static void show(List<Integer> xs) {
        for (int x : xs) System.out.print(x + " ");
        System.out.println();
    }

    public static List<Integer> reverse(List<Integer> xs) {
        return reverseAux(xs, new ArrayList<Integer>());
    }
    
    public static List<Integer> reverseAux(List<Integer> xs, List<Integer> rev) {
        if (xs.size() == 0) return rev;
        rev.add(xs.get(xs.size()-1));
        xs = xs.subList(0, xs.size()-1);
        return reverseAux(xs, rev);
    }
}
