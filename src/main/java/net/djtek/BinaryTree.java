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

    public int size(){
        return size(root);
    }

    private int size(Node node){
        if (node == null){
            return 0;
        }

        return size(node.left) + 1 + size(node.right);
    }
}
