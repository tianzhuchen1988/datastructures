package linkedlist;

import stack.ArrayStack;
import stack.Stack;

public class TestMain {

    public static double testStack(Stack<Integer> stack, int optCount){
        long start = System.nanoTime();

        for(int i = 0; i < optCount; i++){
            stack.push(i);
        }

        for(int i = 0; i < optCount; i++){
            stack.pop();
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        int optCount = 100000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println(testStack(arrayStack, optCount));

        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println(testStack(linkedListStack, optCount));
    }
}
