package com.example.demo.task;

import com.example.demo.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeTask {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "user1", "sales", 1000d, List.of("java", "springboot", "angular", "react")));
        employees.add(new Employee(2, "user2", "sales", 2000d, List.of("java", "springboot", "angular")));
        employees.add(new Employee(3, "user3", "sales", 3000d, List.of("java", "springboot")));
        employees.add(new Employee(4, "user4", "sales", 4000d, List.of("java")));
        employees.add(new Employee(5, "user5", "sales", 4000d, List.of("java")));

        employees.add(new Employee(6, "user6", "accounts", 1000d, List.of("java", "springboot", "angular", "react")));
        employees.add(new Employee(7, "user7", "accounts", 2000d, List.of("java", "springboot", "angular")));
        employees.add(new Employee(8, "user8", "accounts", 3000d, List.of("java", "springboot")));

        employees.add(new Employee(9, "user9", "it", 1000d, List.of("java", "springboot")));
        employees.add(new Employee(10, "user10", "it", 2000d, List.of("java", "springboot")));
        employees.add(new Employee(11, "user11", "it", 3000d, List.of("java")));

        // group by dept, sort by dept, and fetch only top 5 highest salary employees
        Map<String, List<Employee>> groupByDeptTop5 = employees.stream().collect(Collectors.groupingBy(Employee::getDept, LinkedHashMap::new,
                Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSal).reversed()).limit(5).collect(Collectors.toList())
                )
        ));
        groupByDeptTop5.forEach((k, v) -> {
            System.out.println(k + ": " + v.stream().map(e -> e.getSal()).collect(Collectors.toList()));
        });

        // fetch all unique skills
        List<String> allSkills = employees.stream().flatMap(e -> e.getSkills().stream()).collect(Collectors.toList());
        System.out.println("allSkills: " + allSkills);

        // max sal employee
        Employee maxSalEmployee = employees.stream().max(Comparator.comparingDouble(Employee::getSal)).stream().findFirst().orElse(null);
        System.out.println("max sal employee id= " + maxSalEmployee.getId() + ",name=" + maxSalEmployee.getName() + ",sal=" + maxSalEmployee.getSal());

        // average sal employee
        double averageSal = employees.stream().collect(Collectors.averagingDouble(Employee::getSal));
        System.out.println("averageSal: " + averageSal);

        // sum all employees sal
        double sumSal = employees.stream().collect(Collectors.summingDouble(Employee::getSal));
        sumSal = employees.stream().map(e -> e.getSal()).reduce(0d, (a, b) -> a + b);
        System.out.println("sumSal: " + sumSal);
    }
}

