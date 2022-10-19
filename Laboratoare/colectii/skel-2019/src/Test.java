package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {

    //Cerinta 2 - ArrayList
    public static void main(String[] args) {
        Student s1 = new Student("Dino", "Dumitrescu", 7, (double) 8);
        Student s2 = new Student("Iuliu", "Broscuta", 3, (double) 9);
        Student s3 = new Student("Marina", "Popescu", 20, (double) 10);
        Student s4 = new Student("Casandra", "Zamfirescu", 1, (double) 8);
        Student s5 = new Student("Soricel", "Soricescu", 15, (double) 4);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);

        System.out.println("Before sort:");
        for(Student currStudent : studentList) {
            System.out.println(currStudent.toString());
        }

        Collections.sort(studentList);
        System.out.println("After sort:");
        for(Student currStudent : studentList) {
            System.out.println(currStudent.toString());
        }

        //Cerinta 3
        Collections.sort(studentList,
                (o1, o2) -> (int) (o2.getAverageGrade() - o1.getAverageGrade()));

        System.out.println("After lambda sort:");
        for(Student currStudent : studentList) {
            System.out.println(currStudent.toString());
        }

        //Cerinta 4 - Priority Queue
        System.out.println("Priority queue:");
        PriorityQueue<Student> pq = new PriorityQueue<>(studentList.size(),
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return Long.compare(o1.getId(), o2.getId());
                    }
                });
        pq.addAll(studentList);
        while(!pq.isEmpty()) {
            System.out.println(pq.poll());
        }

        //Cerinta 6 - HashMap
        Map<Student, LinkedList<String>> studentMap = new HashMap<>();
        LinkedList<String> list1 = new LinkedList<String>(Arrays.asList("AA", "POO"));
        LinkedList<String> list2 = new LinkedList<String>(Arrays.asList("AA", "POO", "IOCLA"));
        LinkedList<String> list3 = new LinkedList<String>(Arrays.asList("IOCLA"));
        LinkedList<String> list4 = new LinkedList<String>(Arrays.asList("ENGLEZA", "SPORT"));
        LinkedList<String> list5 = new LinkedList<String>(Arrays.asList("POO", "ENGLEZA"));

        studentMap.put(s1, list1);
        studentMap.put(s2, list2);
        studentMap.put(s3, list3);
        studentMap.put(s4, list4);
        studentMap.put(s5, list5);

        for(Map.Entry<Student, LinkedList<String>> entry : studentMap.entrySet()) {
            System.out.println(entry.getKey().toString() +  " -> are materiile: " + entry.getValue().toString());
        }

        //Cerinta 7
        NewLinkedHashSet newLinkedHashSet = new NewLinkedHashSet();
        newLinkedHashSet.add(1);
        newLinkedHashSet.add(64);
        newLinkedHashSet.add(38);
        newLinkedHashSet.add(41);
        newLinkedHashSet.add(5);
        newLinkedHashSet.add(2);

        System.out.println("NewLinkedHashSet:");
        for(Integer iterator : newLinkedHashSet) {
            System.out.println(iterator);
        }

        NewHashSet newHashSet = new NewHashSet();
        newHashSet.add(1);
        newHashSet.add(64);
        newHashSet.add(38);
        newHashSet.add(41);
        newHashSet.add(5);
        newHashSet.add(2);

        System.out.println("NewHashSet:");
        for(Integer iterator : newHashSet) {
            System.out.println(iterator);
        }

        NewTreeSet newTreeSet = new NewTreeSet();
        newTreeSet.add(1);
        newTreeSet.add(64);
        newTreeSet.add(38);
        newTreeSet.add(41);
        newTreeSet.add(5);
        newTreeSet.add(2);

        System.out.println("NewTreeSet:");
        for(Integer iterator : newTreeSet) {
            System.out.println(iterator);
        }

        //Observatii:
        //LinkedHashSet -> elementele sunt afisate in ordinea inserarii
        //HashSet -> elementele sunt afisate aleator
        //TreeSet -> elementele sunt afisate in ordine crescatoare

    }

}
