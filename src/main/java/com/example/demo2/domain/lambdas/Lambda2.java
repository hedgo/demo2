package com.example.demo2.domain.lambdas;

import com.example.demo2.domain.model.Customer;

import java.util.function.*;

public class Lambda2 {
    /////////////////////////////////////////////////////////////////////////////////////////
    //T->boolean
    Predicate<String> szukamyWszystkichAli = s -> "Ala".equals(s);
    Predicate<String> szukamyWszystkichOli = "Ola"::equals;
    Predicate<String> szukamyWszystkichPolaczone = szukamyWszystkichAli.and(szukamyWszystkichOli).or(s -> "Ewa".equals(s));

    //(T,U)->boolean
    BiPredicate<String, Integer> patrzymyCzyZgadzaSieRozmiar = (s, integer) -> s.length() == integer;

    /////////////////////////////////////////////////////////////////////////////////////////
    //T->void
    Consumer<String> drukujemyNapis = s -> System.out.println("s = " + s);

    //(T,U)->void
    BiConsumer<String, Integer> tezDrukujemy = (s, integer) -> String.format("%s%s", s, integer);

    /////////////////////////////////////////////////////////////////////////////////////////
    //T->R
    Function<String, Integer> liczymyDlugoscStringa = s -> s.length();

    //(T,U)->R
    BiFunction<String, Integer, Customer> funkcjaMaDwaWejscia = (s, integer) -> Customer.of(s, integer);
    BiFunction<String, Integer, Customer> funkcjaMaDwaWejscia2 = Customer::of;//super, konstruktor dla R (Customer) z dwoma parametrami

    /////////////////////////////////////////////////////////////////////////////////////////
    //T->T
    UnaryOperator<String> modyfikujemyObiekt = String::toUpperCase;

    //(T,T)->T
    BinaryOperator<String> laczymy = String::concat;

    /////////////////////////////////////////////////////////////////////////////////////////
    //()->T
    Supplier<String> tworzymyCos = () -> "Ala";
    Supplier<String> tworzymyCos2 = String::new;

    /////////////////////////////////////////////////////////////////////////////////////////
}
