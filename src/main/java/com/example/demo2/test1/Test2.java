package com.example.demo2.test1;

import com.example.demo2.domain.model.Customer;

import java.util.Comparator;
import java.util.List;

public class Test2 {

    //Write java function to reverse elements in one directional linked list


    public static void main(String[] args) {


        java.util.LinkedList<Customer> customerLinkedList = new java.util.LinkedList<>();

        customerLinkedList.addAll(
                List.of(
                        Customer.of("Andrzej1", 101),
                        Customer.of("Andrzej2", 102),
                        Customer.of("Andrzej3", 103),
                        Customer.of("Andrzej4", 104)
                )
        );

        System.out.println("customerLinkedList = " + customerLinkedList);


        customerLinkedList.sort(Comparator.comparing(Customer::getAge).reversed());

        System.out.println("customerLinkedList = " + customerLinkedList);

    }
}


//interface LinkedList {
//    next();
//
//    hasNext();
//
//    getFirst();
//
//    add();
//}
