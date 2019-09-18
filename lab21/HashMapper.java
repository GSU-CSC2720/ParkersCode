package lab21;

public class HashMapper<K,V> {
    private Item<K,V>[] map;
    private int size = 10000;
    private int entries = 0;
    
    public HashMapper() {
        map = new Item[size];
    }
    
    public V get(K key) {
        return get(key, null);
    }
    
    public V get(K key, V defaultValue) {
        if (key == null || !contains(key)) return defaultValue;
        
        Item<K,V> curr = map[hash(key)];
        while (!curr.key.equals(key)) curr = curr.next;
        return (V) curr.value;
    }
    
    public void put(K key, V value) {
        if (key == null) return;
        int idx = hash(key);
        if (map[idx] == null) {
            entries++;
            map[idx] = new Item<K,V>(key,value);
            return;
        } 
        
        Item<K,V> curr;
        for (curr = map[idx]; !(curr.key).equals(key); curr = curr.next) {
            if (curr.next == null) { 
                entries += 1;
                curr.next = new Item<K,V>(key, value);
                return;
            }
        }
        curr.value = value; 
    }
    
    public boolean remove(K key) {
        if (key == null || get(key) == null) return false;
        
        entries--;
        
        int idx = hash(key);
        if (map[idx].key == key) {
            map[idx] = map[idx].next;
            return true;
        }
        Item<K,V> curr = map[hash(key)];
        while (curr.next != null) {
            if (curr.next.key.equals(key)) {
                curr.next = curr.next.next;
                break;
            }
        }
        return true;
    }
    
    public boolean contains(K key) {
        if (key == null) return false;
        Item<K,V> bucket = map[hash(key)];
        while (bucket != null) {
            if (bucket.key.equals(key)) return true;
            bucket = bucket.next;
        }
        return false;
    }
    
    public int hash(K key) {
        int hash = 0;
        for (char c : key.toString().toCharArray()) {
            hash = (hash + (int) c) % size;
        }
        return hash;
    }
    
    public K[] keys() {
        K[] res = (K[]) new Object[entries];
        int k = 0;
        for (int i = 0; i < size; i++) {
            Item<K,V> curr = map[i];
            while (curr != null) {
                res[k++] = curr.key;
                curr = curr.next;
            }
        }
        return res;
    }
    
    private static class Item<K,V> {
        K key;
        V value;
        Item<K,V> next;
        
        public Item(K k, V v) { key = k; value = v; }
    }
}
