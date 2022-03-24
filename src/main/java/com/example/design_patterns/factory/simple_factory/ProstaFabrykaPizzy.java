package com.example.design_patterns.factory.simple_factory;

import com.example.design_patterns.factory.common.*;

public class ProstaFabrykaPizzy {
    public Pizza utworzPizze(PizzaType type) {
        switch (type) {
            case HAWAJSKA:
                return new HawajskaPizza();
            case MARGARITA:
                return new MargaritaPizza();
            case SALAMI:
                return new SalamiPizza();
            default:
                throw new IllegalArgumentException("Not supported type: " + type);
        }
    }
}
