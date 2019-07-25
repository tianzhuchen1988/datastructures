package bst;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {

    private class Node{
        public E e;
        public Node left, right;
        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root, e);
    }

    private Node add(Node node, E e){
        if(node == null){
            size++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0){
            node.left = add(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = add(node.right, e);
        }
        return node;
    }

    public boolean contains(E e){
        return contains(root, e);
    }

    private boolean contains(Node node, E e){
        if(node == null){
            return false;
        }

        if(e.compareTo(node.e) == 0){
            return true;
        }else if(e.compareTo(node.e) < 0){
            return contains(node.left, e);
        }else{
            return contains(node.right, e);
        }
    }

    public void preOrder(){
        preOrder(root);
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right != null){
                stack.push(cur.right);
            }
            if(cur.left != null){
                stack.push(cur.left);
            }
        }
    }

    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left != null){
                queue.add(cur.left);
            }
            if(cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    public E minimum(){
        if(root == null){
            throw new IllegalArgumentException("bst is empty.");
        }
        return minimum(root).e;
    }

    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public E maximum(){
        if(root == null){
            throw new IllegalArgumentException("bst is empty.");
        }
        return maximum(root).e;
    }

    private Node maximum(Node node){
        if(node.right == null){
            return node;
        }
        return maximum(node.right);
    }

    public E removeMin(){
        E res = minimum();
        root = removeMin(root);
        return res;
    }

    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E res = maximum();
        root = removeMax(root);
        return res;
    }

    private Node removeMax(Node node){
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }

        node.right = removeMax(node.right);
        return node;
    }

    public void remove(E e){
        root = remove(root, e);
    }

    private Node remove(Node node, E e){
        if(node == null){
            return null;
        }
        if(e.compareTo(node.e) < 0){
            node.left = remove(node.left, e);
        }else if(e.compareTo(node.e) > 0){
            node.right = remove(node.right, e);
        }else{
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = null;
            node.right = null;
            return successor;
        }

        return node;

    }

    public int deep(){
        return deep(root);
    }

    private int deep(Node node){
        int deep = 0;
        if(node == null){
            return 0;
        }

        deep++;
        int leftDeep = deep(node.left);
        int rightDeep = deep(node.right);

        return deep + (leftDeep >= rightDeep ? leftDeep : rightDeep);
    }


    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for(Integer i: nums){
            bst.add(i);
        }

        bst.preOrder();
        System.out.println();
        bst.preOrderNR();

        bst.levelOrder();

        System.out.println(bst.minimum());
        System.out.println(bst.maximum());

        System.out.println();

        bst.remove(5);
        bst.levelOrder();
        System.out.println("deep=" + bst.deep());

        bst.remove(4);
        bst.remove(2);
        System.out.println("deep=" + bst.deep());
    }

}
