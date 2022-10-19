package src;

public class Student implements Comparable<Student>{

    //Cerinta 1
    private String name;
    private String surname;
    private long id;
    private Double averageGrade;

    public Student(String name, String surname, long id, Double averageGrade) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.averageGrade = averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(Double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return name + " " + surname + "  id: " + id + "  average grade: " + averageGrade;
    }

    @Override
    public int compareTo(Student o) {
        if(averageGrade.equals(o.averageGrade)) {
            if(surname.equals(o.surname)) {
                return name.compareTo(o.name);
            }
            else {
                return surname.compareTo(o.surname);
            }
        }
        else {
            return averageGrade.compareTo(o.averageGrade);
        }
    }

    //Cerinta 5
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
