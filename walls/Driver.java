package walls;

public class Driver {
    public static void main(String[] args) {
        List stuff = new PArrayList();
        for (int i = 0; i < 10; i++) stuff.add(i, "String");
        for (int i = 0; i < 10; i++) System.out.println(stuff.get(i));
    }
}
