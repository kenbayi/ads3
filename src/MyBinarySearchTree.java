import java.util.ArrayList;

public class MyBinarySearchTree<K extends Comparable<K>,V>{
    private Node root;

    private class Node {
        private K key;
        private V val;
        private Node left, right;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    // Method to insert a key-value pair into the binary search tree
    public void put(K key, V val) {
        root = put(root, key, val);
    }

    // Recursive helper method to insert a key-value pair into the binary search tree
    private Node put(Node node, K key, V val) {
        if (node == null)
            return new Node(key, val);
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = put(node.left, key, val);
        else
            node.right = put(node.right, key, val);
        return node;
    }

    // Method to get the value associated with a given key from the binary search tree
    public V get(K key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else
                return node.val;
        }
        return null;
    }

    // Method to delete a key-value pair from the binary search tree
    public void delete(K key) {
        root = delete(root, key);
    }

    // Recursive helper method to delete a key-value pair from the binary search tree
    private Node delete(Node node, K key) {
        if (node == null)
            return null;
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
            node.left = delete(node.left, key);
        else if (cmp > 0)
            node.right = delete(node.right, key);
        else {
            if (node.right == null && node.left == null)
                return null;
            if (node.left == null)
                return node.right;

            if (node.right == null)
                return node.left;

            K smallestValue = findSmallestValue(node.left);
            node.key = smallestValue;
            node.left = delete(node.left, smallestValue);
        }
        return node;
    }

    // Method to get an iterable for iterating through the keys of the binary search tree
    public Iterable<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    // Helper method to perform in-order traversal
    // of the binary search tree and populate the keys list
    // traverse left subtree starting from root, and then right subtree.
    private void inOrder(Node node, ArrayList<K> nodes) {
        if (node == null)
            return;

        inOrder(node.left, nodes);
        nodes.add(node.key);
        inOrder(node.right, nodes);
    }

    // Helper method to find the smallest value in the binary search tree
    private K findSmallestValue(Node node) {
        return node.right == null ? node.key : findSmallestValue(node.right);
    }
}

