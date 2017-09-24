package net.djtek;

public class BinaryTree<T extends Comparable<T>> {
    class Node<T extends Comparable<T>> {
        T value;
        Node left;
        Node right;

        Node(T value){
            this.value = value;
        }
    }

    private Node root;

    /**
     * Add a value to the binary tree.  Duplicate values are ignored.
     * @param value The value to add
     */
    public void add(T value){
        root = add(root, value);
    }

    private Node add(Node node, T value){
        if (node == null){
            return new Node(value);
        }

        if (node.value.compareTo(value) > 0){
            node.left = add(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            node.right = add(node.right, value);
        }

        // return the unchanged 'pointer'
        return node;
    }

    /**
     * Determine the binary tree contains a value
     * @param value The value to test
     * @return true if binary tree contains the value, false otherwise
     */
    public boolean contains(T value){
        return contains(root, value);
    }

    private boolean contains(Node node, T value){
        if (node == null){
            return false;
        }

        if (node.value.compareTo(value) > 0){
            return contains(node.left, value);
        } else if (node.value.compareTo(value) < 0) {
            return contains(node.right, value);
        }

        return true;
    }

    /**
     * Return the size, number of nodes, in the binary tree
     * @return The size
     */
    public int size(){
        return size(root);
    }

    public enum PrintOrder {INORDER, PREORDER, POSTORDER};

    /**
     * Utility method to print the binary tree inorder
     */
    public void print(){
        print(PrintOrder.INORDER);
    }

    /**
     * Utility method to print the binary tree
     * @param printOrder The print order
     */
    public void print(PrintOrder printOrder){
        switch(printOrder){
            case INORDER:
                printInOrder(root);
                break;
            case PREORDER:
                printPreOrder(root);
                break;
            case POSTORDER:
                printPostOrder(root);
                break;
        }
    }

    private void printInOrder(Node node){
        if (node != null){
            printInOrder(node.left);
            System.out.print(node.value.toString() + " ");
            printInOrder(node.right);
        }
    }

    private void printPreOrder(Node node){
        if (node != null){
            System.out.print(node.value.toString() + " ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    private void printPostOrder(Node node){
        if (node != null){
            printPostOrder(node.left);
            printPostOrder(node.right);
            System.out.print(node.value.toString() + " ");
        }
    }

    private int size(Node node){
        if (node == null){
            return 0;
        }

        return size(node.left) + 1 + size(node.right);
    }
}