package com.example.design_patterns.factory.simple_factory;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new Pizzeria(new ProstaFabrykaPizzy());
        pizzeria.zamowPizze();
    }
}
