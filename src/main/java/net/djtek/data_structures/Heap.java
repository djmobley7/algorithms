package net.djtek.data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of Max Heap using Java List
 * @param <T> The heap element type
 */
public class Heap<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    private final static int NO_PARENT = -1;
    private final static int NO_CHILD = -1;

    /**
     * Add an element to the heap
     * @param element The element to add
     */
    public void add(T element){
        heap.add(element);

        // maintain max heap
        int childIndex = heap.size() - 1;
        int parentIndex = computeParentIndex(childIndex);
        while (parentIndex != NO_PARENT){
            if (heap.get(childIndex).compareTo(heap.get(parentIndex)) > 0){
                // swap
                swap(childIndex, parentIndex);
            } else {
                break;
            }

            childIndex = parentIndex;
            parentIndex = computeParentIndex(childIndex);
        }
    }

    /**
     * Return the element at the specified index in the heap
     * @param index The index
     * @return The element
     */
    public T get(int index){
        return heap.get(index);
    }

    /**
     * Print contents of heap
     */
    public void print(){
        for (T element : heap){
            System.out.print(element + " ");
        }
    }

    /**
     * Get heap size
     * @return The heap size
     */
    public int size(){
        return heap.size();
    }

    /**
     * Heap sort
     */
    public void sort(){
        for (int i = heap.size() - 1; i > 0; --i){
            swap(i, 0);
            heapify(0, i);
        }
    }

    private void heapify(int index, int size){
        int leftChildIndex = computeLeftChildIndex(index, size);

        // if not leaf node
        if (leftChildIndex != NO_CHILD){
            T parentElement = heap.get(index);
            T leftChildElement = heap.get(leftChildIndex);

            T rightChildElement = null;
            int rightChildIndex = computeRightChildIndex(index, size);
            if (rightChildIndex != NO_CHILD){
                rightChildElement = heap.get(rightChildIndex);
            }

            // is either child > parent?
            if (parentElement.compareTo(leftChildElement) < 0 ||
                (rightChildElement != null && parentElement.compareTo(rightChildElement) < 0)){

                // is right child > left child?
                if (rightChildElement != null &&
                        rightChildElement.compareTo(leftChildElement) > 0){
                    // swap right child with parent and heapify on right child
                    swap(rightChildIndex, index);
                    heapify(rightChildIndex, size);
                } else {
                    // swap left child with parent and heapify on left child
                    swap(leftChildIndex, index);
                    heapify(leftChildIndex, size);
                }
            }
        }
    }

    private int computeLeftChildIndex(int index, int size){
        int leftChildIndex = index * 2 + 1;
        if (leftChildIndex > size - 1){
            leftChildIndex = NO_CHILD;
        }
        return leftChildIndex;
    }

    private int computeRightChildIndex(int index, int size){
        int rightChildIndex = index * 2 + 2;
        if (rightChildIndex > size - 1){
            rightChildIndex = NO_CHILD;
        }
        return rightChildIndex;
    }

    private int computeParentIndex(int index){
        int parentIndex = NO_PARENT;

        if (index > 0){
            parentIndex = index;

            if (parentIndex % 2 == 1){
                parentIndex -= 1;
            } else {
                parentIndex -= 2;
            }

            parentIndex /= 2;

            assert parentIndex >= 0 : "should be >= 0";
        }

        return parentIndex;
    }

    private void swap (int i, int j){
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}