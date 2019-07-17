package array;

public class Student {
    private String name;
    private int score;

    public Student(String name ,int score){
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString(){
        return String.format("Student(%s, %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> students = new Array<>();
        students.addLast(new Student("Jack", 100));
        students.addLast(new Student("Tom", 99));
        students.addLast(new Student("John", 66));

        System.out.println(students);
    }
}
