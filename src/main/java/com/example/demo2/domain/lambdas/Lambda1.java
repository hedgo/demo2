package com.example.demo2.domain.lambdas;

@FunctionalInterface
interface Compute {
    int mathOperation(int a, int b);
}

public class Lambda1 {

    public static void main(String[] args) {
        showComputeResults((a, b) -> a - b);
        showComputeResults((a, b) -> a + b);
        showComputeResults((a, b) -> a * b);
        showComputeResults((a, b) -> a / b);
        showComputeResults(new Compute() {
            @Override
            public int mathOperation(int a, int b) {
                return a * a + b * b;
            }
        });
        Compute compute = (a, b) -> 1000 + a - b;
        showComputeResults(compute);//lambda zamknieta w zmiennej
        showComputeResults(Lambda1::myComputeMethod);//metoda o takiej sygnaturze jak potrzebna tu lambda, wywolanie przez method reference
        showComputeResults(myComputeMethod2());//a to po prostu zwraca potrzebna lambde
    }

    private static int myComputeMethod(int i, int i1) {
        return i * i1 * i * i1;
    }

    private static Compute myComputeMethod2() {
        return (a,b) -> a*a*b*b;
    }

    public static void showComputeResults(Compute compute) {
        int i = compute.mathOperation(10, 5);
        System.out.println("i = " + i);
    }
}
