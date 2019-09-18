package lab3;

/**
 * Use a double recursion to compute the maximum of an array of values.
 */
public class RecursiveMaxOfArray {   
    /**
     * Compute the maximum of a range of values in an array recursively.
     *
     * @param data   An array of integers.
     * @param from  The low index for searching for the maximum.
     * @param to    The high index for searching for the maximum.
     * 
     * preconditions: from <= to, from >=0, to<length, length>0
     *                
     * @return     The maximum value in the array.
     */
    
    public int max(int data[], int from, int to) {
        if (data == null || data.length == 0) {
            throw new BadArgumentsForMaxException("Null or empty data given");
        }
        
        if (from < 0 || to >= data.length || from > to) {
            throw new BadArgumentsForMaxException("bad index args");
        }
        
        if (from == to) return data[from];
        
        int m = (from + to) / 2;
        return Math.max(max(data, from, m), max(data, m+1, to));
    }
}
