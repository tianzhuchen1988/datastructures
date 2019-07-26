package set;

import map.BSTMap;
import map.LinkedListMap;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();
        if(FileOperation.readFile("D:\\idea_projects\\gshop\\datastructures\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTMap<String, Integer> set1 = new BSTMap<>();
            for (String word : words1){
                if(set1.contains(word)){
                    set1.set(word, set1.get(word) + 1);
                }else{
                    set1.add(word, 1);
                }
            }
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("C:\\Users\\Administrator\\Desktop\\tianmai3\\datastructures\\a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            LinkedListSet<String> set2 = new LinkedListSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}
