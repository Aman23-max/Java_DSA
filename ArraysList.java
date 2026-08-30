import java.util.ArrayList;

public class ArraysList {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);

        int el = list.get(2);
        System.out.println(el);

        list.remove(2);
        System.out.println(list);

        list.set(2, 10);
        System.out.println(list);

        System.out.println(list.contains(1));
        System.out.println(list.contains(11));

        list.add(1, 9);
        System.out.println(list);
    }
}
