package com.example.design_patterns.factory.abstract_factory;

import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;

public interface AbstrakcyjnaFabrykaPizzy {
    public Pizza utworzPizze(PizzaType type);
}
