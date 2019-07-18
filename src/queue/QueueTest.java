package queue;

public class QueueTest {

    public static double testQueue(Queue<Integer> queue, int optCount){
        long start = System.nanoTime();

        for(int i = 0; i < optCount; i++){
            queue.enqueue(i);
        }
        for(int i = 0; i < optCount; i++){
            queue.dequeue();
        }

        long end = System.nanoTime();
        return (end - start) / 100000000.0;
    }

    public static void main(String[] args) {
        int optCount = 100000;
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, optCount);
        System.out.println(time1);

        Queue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, optCount);
        System.out.println(time2);
    }
}
