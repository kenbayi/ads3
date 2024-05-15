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
    }
}