package com.example.demo2.lambdas;

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
        Compute compute = (a, b) -> 1000+ a - b;
        showComputeResults(compute);
    }

    public static void showComputeResults(Compute compute) {
        int i = compute.mathOperation(10, 5);
        System.out.println("i = " + i);
    }
}
