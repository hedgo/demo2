package com.example.demo2.tests;

import com.example.demo2.domain.model.Employee;
import com.example.demo2.domain.model.Skill;
import com.example.demo2.domain.new_java.sealed.AudioFile;
import com.example.demo2.domain.new_java.sealed.MP3File;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
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
        Set<Skill> skillList = employeeList.stream()
                .filter(employee -> employee.getAge() > 25)
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .map(Employee::getSkills)
                .flatMap(Collection::stream)
//                .flatMap(skills -> skills.stream())     //to co robie to stream z elementu ktory jest aktualnie procesowany
                .collect(Collectors.toSet());

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
                .collect(Collectors.partitioningBy(
                        employee -> employee.getAge() > 33));
        System.out.println("map = " + map);
    }

    @Test
    void oldestEmp() {
        Optional<Employee> oldestEmp = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        System.out.println("oldestEmp = " + oldestEmp);

        Optional<Employee> oldestEmp2 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(Employee::getAge)));
        System.out.println("oldestEmp2 = " + oldestEmp2);
    }

    @Test
    void partition_and_doing_anything_on_second_level() {
        //super, zrobi partycje a potem moge dac drugi collector i zrobic cokolwiek np policzyc elementy
        Map<Boolean, Long> collect = employeeList.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.getAge() > 30,
                        Collectors.counting()));//tu moge dac cokolwiek np maxBy, sumarizing, itp
        System.out.println("collect = " + collect);
    }

    @Test
    void partition_and_grouping_on_second_level() {
        Map<Boolean, Map<BigDecimal, List<Employee>>> collect = employeeList.stream()
                .collect(Collectors.partitioningBy(
                        employee -> employee.getAge() > 30,
                        Collectors.groupingBy(Employee::getSalary, Collectors.toList()/*toList() is here optional*/)));
        System.out.println("collect = " + collect);
    }

    @Test
    void tesciki() {
        Map<String, Employee> stringEmployeeMap = employeeList.stream()
                .collect(Collectors.toMap(Employee::getName, Function.identity()));
        System.out.println("stringEmployeeMap = " + stringEmployeeMap);
    }

    @Test
    void wiekWszystkichPracownikow() {
        Integer collect = employeeList.stream()
                .collect(Collectors.summingInt(Employee::getAge));
        System.out.println("collect = " + collect);
    };

    @Test
    void lepszySwitch() {
        String player = "MJ";
        switch (player){
            case "MJ":
            case "BO":
                System.out.println("Bulls");
                break;
            case "WE":
            case "ER":
            case "KL":
                System.out.println("Lakers");
                break;
            default:
                System.out.println("Nie znam tego koszykarza");
        }

        //super:) no teraz krociutko
        switch (player) {
            case "MJ", "BO" -> System.out.println("Bulls");
            case "WE", "ER", "KL" -> System.out.println("Lakers");
            default -> System.out.println("Nie znam tego koszykarza");
        }
    };

    @Test
    void nowyInstanceOf() {
        AudioFile audioFile = new MP3File();
        if(audioFile instanceof MP3File myMp3File){
            myMp3File.mojaFunkcja();  //czyli mam juz od razu zrzutowana zmienna, nie musze sam rzutowac
        }
    }
}
