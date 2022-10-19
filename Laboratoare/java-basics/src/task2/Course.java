package task2;

public class Course {
    private String title;
    private String description;

    private Student[] students = new Student[20];

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    Student[] filterYear(int year) {
        Student[] students1 = new Student[20];
        int i, j;
        i = 0;
        j = 0;
        while (students[i] != null) {
            if (students[i].getYear() == year) {
                students1[j] = students[i];
                j++;
            }
            i++;
        }
        return students1;
    }

}
