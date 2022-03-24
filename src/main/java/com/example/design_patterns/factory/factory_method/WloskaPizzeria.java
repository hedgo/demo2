package com.example.design_patterns.factory.factory_method;

import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;
import com.example.design_patterns.factory.common.SalamiPizza;

public class WloskaPizzeria extends Pizzeria {
    @Override
    public Pizza utworzPizze(PizzaType type) {
        System.out.println("Tworze wloska pizze");
        switch (type) {
            case SALAMI:
                return new SalamiPizza();
            default:
                throw new IllegalArgumentException("Not supported type: " + type);
        }
    }
}
