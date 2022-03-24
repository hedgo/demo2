package com.example.design_patterns.factory.abstract_factory;

import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;
import com.example.design_patterns.factory.common.SalamiPizza;

public class WloskaPizzeria implements AbstrakcyjnaFabrykaPizzy {
    @Override
    public Pizza utworzPizze(PizzaType type) {
        System.out.println("Tworze wloska pizze");
        return switch (type) {
            case SALAMI -> new SalamiPizza();
            default -> throw new IllegalArgumentException("Not supported type: " + type);
        };
    }
}
