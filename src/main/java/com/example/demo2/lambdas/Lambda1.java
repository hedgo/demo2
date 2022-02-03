package com.example.demo2.lambdas;

@FunctionalInterface
interface Compute {
    int mathOperation(int a, int b);
}

public class Lambda1 {
    public static void main(String[] args) {
//        Compute compute = (a, b) -> a - b;
//        int substract = compute.mathOperation(10, 5);
//        System.out.println("substract = " + substract);

        showComputeResults((a, b) -> a - b);
        showComputeResults((a, b) -> a + b);
        showComputeResults((a, b) -> a * b);
        showComputeResults((a, b) -> a / b);
    }

    public static void showComputeResults(Compute compute){
        int i = compute.mathOperation(10, 5);
        System.out.println("i = " + i);
    }
}
