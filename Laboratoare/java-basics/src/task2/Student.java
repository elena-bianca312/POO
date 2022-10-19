package task2;

public class Student {
    private String name;
    private int year;

    public Student(String name, int year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    //dupa indicatiA din cerinta
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", year=" + year +
                '}';
    }

}
