package lab21;

public class HashBag<T> implements BagInterface<T> {

    HashMapper<T,Integer> bag = new HashMapper<>();
    private int numberOfEntries;
    private boolean integrityOK = false;     
    
    public HashBag() {
        numberOfEntries = 0; integrityOK = true;
    }
    
    public int getCurrentSize()         { return numberOfEntries; }
    public boolean isEmpty()            { return numberOfEntries == 0; }
    public boolean contains(T entry)    { return bag.contains(entry); }
    public int getFrequencyOf(T entry)  { return bag.get(entry, 0); }
    public void clear()                 { bag = new HashMapper<>(); numberOfEntries = 0;} 
    
    
    public boolean add(T newEntry) {
        bag.put(newEntry, bag.get(newEntry,0) + 1);
        numberOfEntries++;
        return true;
    }

    public T remove() {
        if (isEmpty()) return null;

        T randItem = random(bag.keys());
        remove(randItem);
        return randItem;
    }
    
    public boolean remove(T entry) {
        if (!bag.contains(entry)) return false;
        
        numberOfEntries--;
        int quantity = bag.get(entry,0);
        
        if (quantity > 1)   bag.put(entry, quantity - 1);
        else                bag.remove(entry);
        return true;  
    }
    
    public T[] toArray() {
        T[] res  = (T[]) new Object[numberOfEntries];
        T[] keys = bag.keys();
        for (int i = 0, k = 0; i < keys.length; i++)
            for (int j = 0; j < bag.get(keys[i]); j++) 
                res[k++] = keys[i];
        return res;
    }
    
    public boolean equals(HashBag<T> other) {
        if (numberOfEntries != other.getCurrentSize()) return false;
        
        T[] keys = bag.keys();
        for (int i = 0; i < keys.length; i++) {
            if (getFrequencyOf(keys[i]) != other.getFrequencyOf(keys[i])) {
                return false;
            }
        }
        return true;
    }  

    public boolean duplicateAll() {
        T[] keys = bag.keys();
        numberOfEntries *= 2;
        for (int i = 0; i < keys.length; i++)
            bag.put(keys[i], bag.get(keys[i]) * 2);
        return true;
    }  
    
    public void removeDuplicates() {
        T[] keys = bag.keys();
        numberOfEntries = keys.length;
        for (int i = 0; i < keys.length; i++) 
            bag.put(keys[i], 1);
    }
    
    private T random(T[] keys) {
        return keys[(int) (Math.random() * keys.length)];
    }
}
