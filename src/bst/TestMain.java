package bst;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestMain {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Random random = new Random();
        for(int i = 0; i < 1000; i++){
            bst.add(random.nextInt(10000));
        }

        List<Integer> nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMin());
        }

        System.out.println(nums);

        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i - 1) > nums.get(i)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("Test removeMin end.");

        for(int i = 0; i < 1000; i++){
            bst.add(random.nextInt(10000));
        }

        nums = new ArrayList<>();
        while(!bst.isEmpty()){
            nums.add(bst.removeMax());
        }
        System.out.println(nums);

        for(int i = 1; i < nums.size(); i++){
            if(nums.get(i - 1) < nums.get(i)){
                throw new IllegalArgumentException("error");
            }
        }
        System.out.println("Test removeMax end.");
    }

}
