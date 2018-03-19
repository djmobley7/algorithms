package net.djtek.data_structures;

/**
 * Stack implementation using LinkedList
 * @param <T> The value type stored by the stack
 */
public class Stack<T>{
    private LinkedList<T> list = new LinkedList<>();

    /**
     * Push a value onto the stack
     * @param value The value
     */
    public void push(T value){
        list.addToFront(value);
    }

    /**
     * Pop a value from the stack
     * @param value The value or null if the stack is empty
     * @return
     */
    public T pop(T value){
        return list.removeFromFront();
    }

    /**
     * Get the value on top of the stack
     * @return The value or null if the stack is empty
     */
    public T peek(){
        return list.peekFront();
    }

    /**
     * Get the stack size
     * @return The stack size
     */
    public int size(){
        return list.length();
    }

    /**
     * Return whether or not the stack is empty (size is 0)
     * @return True if empty, false otherwise
     */
    public boolean empty(){
        return list.length() == 0;
    }
}