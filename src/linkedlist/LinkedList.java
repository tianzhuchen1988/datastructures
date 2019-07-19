package linkedlist;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;
        size++;
    }

    public void add(int index, E e){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Index is invalid.");
        }
        if(index == 0){
            addFirst(e);
        }else{
            Node prev = head;
            for(int i = 0; i < index - 1; i++){
                prev = prev.next;
            }
            Node newNode = new Node(e);
            newNode.next = prev.next;
            prev.next = newNode;
            size++;
        }
    }

    public void addLast(E e){
        add(size, e);
    }

}
