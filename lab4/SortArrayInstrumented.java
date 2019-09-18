package lab4;

public class SortArrayInstrumented {
    
    long total, min, max;
    long comparisons;
    int trials;
    
    public SortArrayInstrumented() {
        total = 0;
        min = Long.MAX_VALUE;
        max = 0;
        trials = 0;
    }
    
    public long totalComp() { return total; }
    public long minComp()   { return min; }
    public long maxComp()   { return max; }
    public double avgComp() { return (double) total / trials; }

    public <T extends Comparable<? super T>> void selectionSort(T[] a, int n) {
        for (int index = 0; index < n - 1; index++) {
            int indexOfNextSmallest = getIndexOfSmallest(a, index, n - 1);
            swap(a, index, indexOfNextSmallest);
        }
        updateStats();
    } 

    private void updateStats() {
        total += comparisons;
        min = Math.min(comparisons, min);
        max = Math.max(comparisons, max);
        trials++;
        comparisons = 0;
    }

    public <T extends Comparable<? super T>> int getIndexOfSmallest(T[] a, int first, int last) {
        T min = a[first];
        int indexOfMin = first;
        for (int index = first + 1; index <= last; index++) {
            comparisons++;
            if (a[index].compareTo(min) < 0) {
                min = a[index];
                indexOfMin = index;
            } 
        } 
        return indexOfMin;
    }


    private <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } 
}