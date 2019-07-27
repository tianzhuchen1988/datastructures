package heap;

import array.Array;

public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for(int i = parent(data.getSize() - 1); i >=0; i--){
            siftDown(i);
        }
    }

    public int getSize(){
        return data.getSize();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void add(E e){
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    public E findMax(){
        if(data.isEmpty()){
            throw new IllegalArgumentException("heap is empty.");
        }
        return data.get(0);
    }

    public E extractMax(){
        if(data.isEmpty()){
            throw new IllegalArgumentException("heap is empty.");
        }
        E ret = data.get(0);
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while(leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if(j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0){
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j)) >= 0){
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    private void siftUp(int k){
        while(k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    private int parent(int index){
        if(index == 0){
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index){
        return index * 2 + 1;
    }

    private int rightChild(int index){
        return index * 2 + 2;
    }

    public E replace(E e){
        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

}
