package com.example.design_patterns.factory.abstract_factory;


import com.example.design_patterns.factory.common.HawajskaPizza;
import com.example.design_patterns.factory.common.MargaritaPizza;
import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;

public class AmerykanskaPizerria implements AbstrakcyjnaFabrykaPizzy {
    @Override
    public Pizza utworzPizze(PizzaType type) {
        System.out.println("Tworze amerykanska pizze");
        return switch (type) {
            case HAWAJSKA -> new HawajskaPizza();
            case MARGARITA -> new MargaritaPizza();
            default -> throw new IllegalArgumentException("Not supported type: " + type);
        };
    }
}
