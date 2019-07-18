package queue;

public interface Queue<E> {
    void enqueue(E e);
    E dequeue();
    int getSize();
    boolean isEmpty();
    E getFront();
}
