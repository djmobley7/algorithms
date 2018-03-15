package net.djtek.data_structures;

public class LinkedList<T> {
    class Node{
        T value;
        Node next;
        Node prev;

        Node(T value){
            this.value = value;
        }
    }

    private Node root;
    private Node tail;

    public void addToFront(T value){
        // TODO
    }

    public void addToTail(T value){
        if (root == null){
            root = new Node(value);
            tail = root;
        } else {
            tail.next = new Node(value);
            tail.next.prev = tail;
            tail = tail.next;
        }
    }

    public T removeFromFront(){
        // TODO
        return null;
    }

    public T removeFromTail(){
        T result = null;

        if (root != null) {
            assert tail != null : "tail should not be null";

            // get return value
            result = tail.value;

            // move tail back and update next pointer (gc will handle the rest)
            tail = tail.prev;
            tail.next = null;
        }

        return result;
    }
}
