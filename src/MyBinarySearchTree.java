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
    public void put(K key, V val) {
        root = put(root, key, val);
    }

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

    public void delete(K key) {
        root = delete(root, key);
    }

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
    public Iterable<K> iterator() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        return keys;
    }

    private void inOrder(Node node, ArrayList<K> nodes) {
        if (node == null)
            return;

        inOrder(node.left, nodes);
        nodes.add(node.key);
        inOrder(node.right, nodes);
    }
    private K findSmallestValue(Node node) {
        return node.right == null ? node.key : findSmallestValue(node.right);
    }
}

