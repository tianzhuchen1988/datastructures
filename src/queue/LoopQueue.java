package queue;

public class LoopQueue<E> implements Queue<E>{

    private E[] data;
    private int front;
    private int tail;
    private int size;

    public LoopQueue(int capacity){
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public E getFront() {
        return null;
    }
}
