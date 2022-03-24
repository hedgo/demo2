package com.example.design_patterns.factory.factory_method;

import com.example.design_patterns.factory.common.PizzaType;

public class Main {
    public static void main(String[] args) {
        Pizzeria pizzeria = new WloskaPizzeria();
        pizzeria.zamowPizze(PizzaType.SALAMI);

        pizzeria = new AmerykanskaPizerria();
        pizzeria.zamowPizze(PizzaType.SALAMI);
    }
}
