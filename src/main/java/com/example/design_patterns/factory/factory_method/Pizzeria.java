package com.example.design_patterns.factory.factory_method;

import com.example.design_patterns.factory.common.Pizza;
import com.example.design_patterns.factory.common.PizzaType;
import com.example.design_patterns.factory.simple_factory.ProstaFabrykaPizzy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public abstract class  Pizzeria {

    public void zamowPizze(PizzaType type) {
        Pizza pizza;
        //Tworzymy Pizze, czyli niejako agregat dla mojej domeny, na którym będziemy wykonywać operacje
        pizza = utworzPizze(type);
        String nazwaPizzy = pizza.zwrocNazwe();
        System.out.println("nazwaPizzy = " + nazwaPizzy);
    }

    //FACTORY METHOD
    //Tutaj delegujemy tworzenie Pizz do klas potomnych Pizerri
    //Tylko troche lipa ze zeczywisty obiekt ma metode tworzenia siebie..
    public abstract Pizza utworzPizze(PizzaType type);
}
