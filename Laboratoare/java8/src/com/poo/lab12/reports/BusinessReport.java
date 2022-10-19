package com.poo.lab12.reports;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.poo.lab12.entities.*;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess

        // groupingBy - used for grouping objects by some property and storing results in a Map instance.
        return business.getEmployees().stream().collect(Collectors.groupingBy(Employee::getDisability));
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count

        TreeSet<Project> differentProjectsWorkedByCurrentFemaleEmployees = new TreeSet<>(Comparator.comparing(Project::getName));

        business.getEmployees().stream().filter(employee -> employee.getGender().equals(Gender.FEMALE)).map(Employee::getProjects).collect(Collectors.toList())
                        .forEach(differentProjectsWorkedByCurrentFemaleEmployees::addAll);

        return differentProjectsWorkedByCurrentFemaleEmployees.size();

    }

    public static SortedSet<Employee> getEmployeesMaxByReligionMinByGenderSortedByCitySortedByAge(Business business) {
        // Get the employees with majority by religion, from this group select the subgroup that has the minority by gender
        // Sort the set by city and, in case of equality, by age

        return null;
    }

    public static Religion getReligionOfEmployeesWithMostAccounts(Business business) {
        // Group employees by religion, count the accounts in each group, return the religion with biggest score

        var employees = business.getEmployees().stream();

        var religionMap = employees.collect(Collectors.groupingBy(Employee::getReligion));

        var religionMapNumber = religionMap.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, religionListEntry -> religionListEntry.getValue().stream()
                        .mapToInt(employee -> employee.getAccounts().size()).sum()));

        return Collections.max(religionMapNumber.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        // Map the employees by religion (Map<Religion, List<Employee>>) then map each of the lists by city (Map<String, List<Employee>>)
        // Hint: use Collectors.groupingBy(Function, Collector)

        return business.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getReligion, Collectors.groupingBy(Employee::getGender)));
    }

    public static Map<Project, Map<String, List<Employee>>> getEmployeesOnSameProjectAndCity(Business business) {
        // Map the employees to the business projects (not to their respective projects)

        return null;
    }
}
