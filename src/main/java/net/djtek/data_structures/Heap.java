package net.djtek.data_structures;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danmobley on 9/25/17.
 */
public class Heap<T extends Comparable<T>> {
    private List<T> heap = new ArrayList<>();

    /**
     * Add an element to the heap
     * @param element The element to add
     */
    public void add(T element){
        heap.add(element);

        // maintain max heap structure by comparing the child's value to it's parent
        int childIndex = heap.size() - 1;
        int parentIndex = computeParentIndex(childIndex);
        while (parentIndex != -1){
            if (heap.get(childIndex).compareTo(heap.get(parentIndex)) > 0){
                // swap
                T temp = heap.get(parentIndex);
               heap.set(parentIndex, heap.get(childIndex));
               heap.set(childIndex, temp);
            } else {
                break;
            }

            childIndex = parentIndex;
            parentIndex = computeParentIndex(childIndex);
        }
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

    private int computeParentIndex(int childIndex){
        int parentIndex = -1; // no parent

        if (childIndex > 0){
            parentIndex = childIndex;

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

//    private int computeLeftChildIndex(int parentIndex){
//        return (parentIndex * 2 + 1);
//    }
//
//    private int computeRightChildIndex(int parentIndex){
//        return (parentIndex * 2 + 2);
//    }
}