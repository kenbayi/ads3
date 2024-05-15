public class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    // Override the equals method to compare MyTestingClass objects based on id and name
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyTestingClass that = (MyTestingClass) obj;
        return id == that.id;
    }

    // Overriding the hashCode method to provide a custom hash code implementation
    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString() {
        return "MyTestingClass{id=" + id + "}";
    }
}
