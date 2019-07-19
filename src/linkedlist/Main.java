package linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 5; i++){
            linkedList.addLast(i);
        }
        System.out.println(linkedList);

        linkedList.set(2, 666);
        System.out.println(linkedList);
    }
}
