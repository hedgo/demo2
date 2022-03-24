package com.example.design_patterns.factory.abstract_factory;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria(new WloskaPizzeria());
        pizzeria.zamowPizze();
    }
}
