package com.example.design_patterns.factory.abstract_factory;

import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Pizzeria {
    private AbstrakcyjnaFabrykaPizzy abstrakcyjnaFabrykaPizzy;//FABRYKA ABSTRAKCYJNA

    public void zamowPizze() {//kod pracuje na abstrakci, jest niezmienny, moge mu wstrzyknac zmienne zachowania fakryki
        Pizza pizza = abstrakcyjnaFabrykaPizzy.utworzPizze(PizzaType.SALAMI);
        String nazwa = pizza.zwrocNazwe();
        System.out.println("nazwa = " + nazwa);
    }

}
