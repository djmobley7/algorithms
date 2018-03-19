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

    private Node front;
    private Node tail;

    public void addToFront(T value){
        Node node = new Node(value);

        // update front
        node.next = front;
        if (front != null){
            front.prev = node;
        }
        front = node;

        // update tail
        if (tail == null){
            tail = front;
        }
    }

    public void addToTail(T value){
        Node node = new Node(value);

        // update tail
        node.prev = tail;
        if (tail != null){
            tail.next = node;
        }
        tail = node;

        // update front
        if (front == null){
            front = tail;
        }
    }

    public T removeFromFront(){
        T result = null;

        if (front != null){
            result = front.value;

            // update tail
            if (tail == front){
                tail = front.next;
            }

            front = front.next;
        }

        return result;
    }

    public T removeFromTail(){
        T result = null;

        if (front != null) {
            assert tail != null : "tail should not be null";

            // get return value
            result = tail.value;

            // move tail back and update next pointer (gc will handle the rest)
            tail = tail.prev;
            tail.next = null;
        }

        return result;
    }

    public int length(){
        int result = 0;
        for (Node current = front; current != null; current = current.next){
            ++result;
        }
        return result;
    }

    @Override
    /**
     * Simple override of toString() to create comman-delimited list of
     * node values
     */
    public String toString(){
        StringBuilder sb = new StringBuilder ();
        for (Node current = front; current != null; current = current.next){
            if (sb.length() > 1){
                sb.append(", ");
            }
            sb.append(current.value);
        }
        return sb.toString();
    }
}
