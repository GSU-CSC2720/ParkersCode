package walls;

public class PArrayList implements List {

    private Object[] items;
    private int capacity = 100;
    private int size = 0;
    
    public PArrayList() {
        items = new Object[capacity];
    }
    
    @Override
    public void add(int index, Object item) {
        if (index > -1 && index <= size) {
            for (int i = size-1; i >= index; i--) {
                items[i+1] = items[i];
            }
        }
        items[index] = item;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return items[index];
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        for (int i = index+1; i < size; i++) {
            items[i-1] = items[i];
            items[i] = null;
        }
    }

    @Override
    public void removeAll() {
        items = new Object[capacity];
        
    }

}
