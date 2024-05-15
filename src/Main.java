import java.util.Random;

public class Main {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();

        // Add 10,000 random elements to the table
        Random random = new Random();
        for (int i = 0; i < 10000; i++) {
            int id = random.nextInt(10000);
            String name = "Student_" + random.nextInt(10000);
            MyTestingClass key = new MyTestingClass(id);
            Student value = new Student(name);
            table.put(key, value);
        }

        table.printHashTable();

        //BST testing
        MyBinarySearchTree<Integer, String> bst = new MyBinarySearchTree<>();

        // Adding elements to the binary search tree
        bst.put(50, "Fifty");
        bst.put(30, "Thirty");
        bst.put(70, "Seventy");
        bst.put(20, "Twenty");
        bst.put(40, "Forty");
        bst.put(60, "Sixty");
        bst.put(80, "Eighty");

        System.out.println("Value for key 40: " + bst.get(40));

        bst.delete(40);
        bst.delete(60);
        System.out.println("Value for key 40 after deletion: " + bst.get(40));
        System.out.println("Keys in ascending order:");

        Iterable<Integer> iterator = bst.iterator();
        for (Integer key : iterator) {
            System.out.print(key + " ");
        }
    }
}