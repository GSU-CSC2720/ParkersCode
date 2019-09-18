package lab21;

public final class ArrayBag<T> implements BagInterface<T> {
	
    private final T[] bag; 
	private int numberOfEntries;
    private boolean integrityOK = false;
    private static final int DEFAULT_CAPACITY = 25;
	private static final int MAX_CAPACITY = 10000;

	
	/*********************************************************************
    * METHODS TO BE COMPLETED 
    * 
    *   1) equals 
    *   2) remove 
    *   3) duplicateAll 
    *   4) removeDuplicates  
    * 
    ************************************************************************/
	
    // 1) equals O(n^2) 
	
	/* We could speed things up with sorting or hashing
	 * but this approach gets the job done!
	 */
    public boolean equals(ArrayBag<T> other) {
        if (getCurrentSize() != other.getCurrentSize()) return false;
        
        for (int i = 0; i < numberOfEntries; i++) {
            
            int freq1 = getFrequencyOf(bag[i]);
            int freq2 = other.getFrequencyOf(bag[i]);
            
            if (freq1 != freq2) return false;
        }
        return true;
    } 
    
    
    // 2) remove (modified) O(1)
    
    public T remove() {
        checkIntegrity();
        return removeEntry((int) (Math.random() * numberOfEntries));
    }
    
    
    // 3) duplicateAll O(n)
    
    public boolean duplicateAll() {
        if (numberOfEntries * 2 > bag.length) return false;

        int n = numberOfEntries;
        for (int i = 0; i < n; i++) bag[i+n] = bag[i];
        numberOfEntries *= 2;
        return true;
    }  
    

    // 4) removeDuplicates O(n^2)
    
    /* 
     * Also good candidate for sorting or hashing 
     */
    
    public void removeDuplicates() {
        checkIntegrity();
        for (int i = 0; i < numberOfEntries; i++) {
            if (getIndexOf(bag[i]) != i) {
                removeEntry(i--);
            }
        }
    }
	
    /*********************************************************************************/	
	
	
	//Creates an empty bag whose initial capacity is 25.
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	} 
	
	public ArrayBag(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {
            // The cast is safe because the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; // Unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        } else {
            String message = "Attempt to create a bag whose capacity exceeds allowed maximum.";
            throw new IllegalStateException(message);
        }
	}
   
	public boolean add(T newEntry) {
	    if (isArrayFull()) return false;
	 
	    checkIntegrity();
	    
        bag[numberOfEntries++] = newEntry;
        return true;
	} 
   
	public T[] toArray() {
		checkIntegrity();
        @SuppressWarnings("unchecked") // The cast is safe because the new array contains null entries.
        T[] result = (T[])new Object[numberOfEntries]; // Unchecked cast
        for (int i = 0; i < numberOfEntries; i++) {
            result[i] = bag[i];
        }
        return result;
	} 

	public boolean isEmpty() {
        return numberOfEntries == 0;
	}

	public int getCurrentSize() { 
	    return numberOfEntries; 
	} 


	public int getFrequencyOf(T entry) {
		
	    checkIntegrity();
        
		int count = 0;
        for (int i = 0; i < numberOfEntries; i++) {
            if (entry.equals(bag[i])) count++;
        }    
        return count;
	} 

    public boolean contains(T entry) {
        checkIntegrity();
        return getIndexOf(entry) > -1;
	}
   
	public void clear() {
        while (!isEmpty()) remove();
	}
	
	public boolean remove(T entry) {
		
	    checkIntegrity();
        
        int index = getIndexOf(entry);
        if (index > -1) {
            removeEntry(index);
            return true;
        }
        return false;
	}   
	
   // Returns true if the array bag is full, or false if not.
	private boolean isArrayFull() {
		return numberOfEntries == bag.length;
	}

	private int getIndexOf(T entry) { 
        for (int i = 0; i < numberOfEntries; i++) {
            if (entry.equals(bag[i])) return i;
        }
        return -1;
	}

	private T removeEntry(int givenIndex) {
	     if (givenIndex < 0 || givenIndex >= numberOfEntries) return null;
		 T result = null;
         result = bag[givenIndex];          // Entry to remove
         int lastIndex = numberOfEntries - 1;
         bag[givenIndex] = bag[lastIndex];  // Replace entry to remove with last entry
         bag[lastIndex] = null;             // Remove reference to last entry
         numberOfEntries--;
         return result;
	}
   
    // Throws an exception if this object is not initialized.
    private void checkIntegrity() {
      if (!integrityOK) throw new SecurityException("HashBag object is corrupt.");
    } 
   
    public String toString() {
        
        String result = "Bag[ ";
        
        for (int index = 0; index < numberOfEntries; index++) {
            result += bag[index] + " ";
        } // end for
        
        result += "]";
        return result;
    }     
}



