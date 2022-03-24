package com.example.design_patterns.factory.simple_factory;

import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pizzeria {
    private ProstaFabrykaPizzy prostaFabrykaPizzy;

    public void zamowPizze() {
        Pizza pizza;
        //Tworzymy Pizze, czyli niejako agregat dal mojej domeny, na którym będziemy wykonywać operacje
        pizza = prostaFabrykaPizzy.utworzPizze(PizzaType.MARGARITA);
        String nazwaPizzy = pizza.zwrocNazwe();
        System.out.println("nazwaPizzy = " + nazwaPizzy);
    }
}
