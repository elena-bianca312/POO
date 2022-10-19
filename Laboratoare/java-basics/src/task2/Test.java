package task2;

import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //initializam cursul si studentii (ca obiecte)
        Course course = new Course();

        Student student0 = new Student("Doinita", 2020);
        Student student1 = new Student("Margherita", 2018);
        Student student2 = new Student("Papadopol", 2020);
        Student student3 = new Student("Ion", 2016);


        course.getStudents()[0] = student0;
        course.getStudents()[1] = student1;
        course.getStudents()[2] = student2;
        course.getStudents()[3] = student3;

        //citim anul dat ca parametru in linia de comanda (editat din configurations)
        //sintaxa folosita este cea propusa in laborator
        int year = 0;
        if (args.length > 0) {
            try {
                year = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {
                System.err.println("Argument" + args[0] + " must be an integer.");
                System.exit(1);
            }
        }

        //declaram un alt array de studenti care va lua valoarea functiei din obiectul course
        Student[] studentsFiltered = course.filterYear(year);

        //afisam studentii cu anul potrivit
        int i = 0;
        while(studentsFiltered[i] != null) {
            System.out.println(studentsFiltered[i].getName());
            i++;
        }

        //task3
        Student student4 = new Student("Ana", 2000);
        Student student5 = new Student("Ana", 2000);

        System.out.println(student4.equals(student5));
    }
}
