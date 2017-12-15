package ivan.boiko.algorithms.prometheus;

public class Main {

    public static void main(String[] args) {

        LinkedList list = new LinkedList();

        list.add(1);
        list.add(4);
        list.add(2);
        list.add(5);
        list.add(8);

        System.out.println(list);

        System.out.println("size " + list.size());

        System.out.println("4 elem = " + list.get(4));

        list.add(9);

        System.out.println(list);

        System.out.println("size " + list.size());

        System.out.println("4 elem = " + list.get(4));

        System.out.println(list.delete(4));
        System.out.println(list.delete(5));
        System.out.println(list.delete(0));
        System.out.println(list.delete(-1));

        System.out.println(list);

        System.out.println("4 elem = " + list.get(4));


        System.out.println("size " + list.size());

    }
}
