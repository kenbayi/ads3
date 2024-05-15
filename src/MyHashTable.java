public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString(){
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private static final int M = 11;
    private int size;

    public MyHashTable() {
        this(M);
    }

    // Constructor initializing the hash table with a specified number of buckets.
    private MyHashTable(int M) {
        chainArray = new HashNode[M];
        size = 0;
    }

    // Hash function to compute the index for a given key.
    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }

    // Method to insert a key-value pair into the hash table.
    public void put(K key, V value) {
        int bucket = hash(key);
        HashNode<K, V> head = chainArray[bucket];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = chainArray[bucket];
        HashNode<K, V> newNode = new HashNode<K, V>(key, value);
        newNode.next = head;
        chainArray[bucket] = newNode;
    }

    // Method to retrieve the value associated with a given key.
    public V get(K key) {
        int bucket= hash(key);
        HashNode<K, V> head = chainArray[bucket];

        while (head != null) {
            if (head.key.equals(key))
                return head.value;

            head = head.next;
        }
        return null;
    }

    // Method to remove a key-value pair from the hash table.
    public V remove(K key) {
        int bucket = hash(key);
        HashNode<K, V> head = chainArray[bucket];
        HashNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev != null) {
                    prev.next = head.next;
                } else {
                    chainArray[bucket] = head.next;
                }
                size--;
                return head.value;
            }
            prev = head;
            head = head.next;
        }
        return null;
    }

    // Method to check if a value exists in the hash table.
    public boolean contains(V value) {
        for (int i = 0; i < M; i++) {
            HashNode<K, V> head = chainArray[i];
            while (head != null) {
                if (head.value.equals(value))
                    return true;

                head = head.next;
            }
        }
        return false;
    }

    // Method to retrieve the key associated with a given value.
    public K getKey(V value) {
        for (int i = 0; i < M; i++) {
        HashNode<K, V> head = chainArray[i];
        while (head != null) {
            if (head.value.equals(value))
                return head.key;

            head = head.next;
        }
    }
        return null;
    }

    public void printHashTable() {
        System.out.println("Elements in hash table buckets:");
        for (int i = 0; i < M; i++) {
            int count = 0;
            HashNode<K, V> node = chainArray[i];
            while (node != null) {
                count++;
                node = node.next;
            }

            System.out.println("Bucket " + (i + 1) + " has " + count + " elements.");
        }
    }

}
