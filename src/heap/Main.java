package heap;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int count = 100000;
        Random random = new Random();
        MaxHeap<Integer> heap = new MaxHeap<>();
        for(int i = 0; i < count; i++){
            heap.add(random.nextInt(Integer.MAX_VALUE));
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < heap.getSize(); i++){
            list.add(heap.extractMax());
        }

        for(int i = 1; i < list.size(); i++){
            if(list.get(i - 1) < list.get(i)){
                throw new IllegalArgumentException("error");
            }
        }

        System.out.println("Test completed.");
    }
}
