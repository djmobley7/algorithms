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

    /**
     * Add value to front of linked list
     * @param value The value to add
     */
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

    /**
     * Add value to tail of linked list
     * @param value The value to add
     */
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

    /**
     * Remove and return the value from the front of the linked list
     * @return The value, or null if empty
     */
    public T removeFromFront(){
        T result = null;

        if (front != null){
            assert tail != null : "tail should not be null";

            result = front.value;

            // update front
            front = front.next;
            if (front != null){
                front.prev = null;
            }

            // update tail
            if (front == null){
                tail = null;
            }
        }

        return result;
    }

    /**
     * Remove and return the value from the tail of the linked list
     * @return The value, or null if empty
     */
    public T removeFromTail(){
        T result = null;

        if (tail != null){
            assert front != null : "front should not be null";

            result = tail.value;

            // update tail
            tail = tail.prev;
            if (tail != null) {
                tail.next = null;
            }

            // update front
            if (tail == null){
                front = null;
            }
        }

        return result;
    }

    /**
     * Return value at the front of the list
     * @return The value or null if the linked list is empty
     */
    public T peekFront(){
        T result = null;
        if (front != null){
            result = front.value;
        }
        return result;
    }

    /**
     * Return the length of the linked list
     * @return The length
     */
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
            if (sb.length() > 0){
                sb.append(", ");
            }
            sb.append(current.value);
        }
        return sb.toString();
    }
}
