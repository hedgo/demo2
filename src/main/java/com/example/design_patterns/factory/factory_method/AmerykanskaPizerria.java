package com.example.design_patterns.factory.factory_method;


import com.example.design_patterns.factory.common.*;

public class AmerykanskaPizerria extends Pizzeria {
    @Override
    public Pizza utworzPizze(PizzaType type) {
        System.out.println("Tworze amerykanska pizze");
        switch (type) {
            case HAWAJSKA:
                return new HawajskaPizza();
            case MARGARITA:
                return new MargaritaPizza();
            default:
                throw new IllegalArgumentException("Not supported type: " + type);
        }
    }
}
