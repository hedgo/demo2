package com.example.demo2;

import com.example.demo2.domain.model.Employee;
import com.example.demo2.domain.model.Skill;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@SpringBootTest
class Demo2ApplicationTests {
    List<Employee> employeeList = Arrays.asList(
            Employee.of("Andy", 40, BigDecimal.valueOf(1000), List.of(Skill.JAVA, Skill.DOCKER)),
            Employee.of("Jack", 32, BigDecimal.valueOf(800), Stream.of(Skill.DDD, Skill.AWS, Skill.DOCKER).collect(Collectors.toList())),
            Employee.of("Roy", 26, BigDecimal.valueOf(500), Arrays.asList(Skill.C, Skill.KUBERNATES, Skill.DESIGN)),
            Employee.of("Mary", 34, BigDecimal.valueOf(850), new ArrayList<>() {{
                add(Skill.JAVA);
                add(Skill.DOCKER);
            }}));

    @Test
    void contextLoads() {
        List<Skill> skillList = employeeList.stream()
                .filter(employee -> employee.getAge() > 25)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getSkills)
                .flatMap(Collection::stream)
//                .flatMap(skills -> skills.stream())     //to co robie to stream z elementu ktory jest aktualnie procesowany
                .collect(Collectors.toList());

        System.out.println("skillList = " + skillList);
    }

    @Test
    void contextLoads2() {
        DoubleSummaryStatistics doubleSummaryStatistics = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getAge));
        System.out.println("doubleSummaryStatistics = " + doubleSummaryStatistics);

    }

    @Test
    void partycjonowanie() {
        Map<Boolean, List<Employee>> map = employeeList.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getAge() > 33));
        System.out.println("map = " + map);
    }

    @Test
    void oldestEmp() {
        Optional<Employee> oldestEmp = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println("oldestEmp = " + oldestEmp);

        Optional<Employee> oldestEmp2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
        System.out.println("oldestEmp2 = " + oldestEmp2);
    }


}
