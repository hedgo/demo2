package com.example.demo2.domain.lambdas;

@FunctionalInterface
interface Compute {
    int mathOperation(int a, int b);
}


class MyOldStyleCompute implements Compute {

    @Override
    public int mathOperation(int a, int b) {
        return a+100+b+100;
    }
}

public class Lambda1 {

    public static void main(String[] args) {

        //1. OldStyle1 - so bad..:)
        showComputeResults(new MyOldStyleCompute());

        
        //2. OldStyle2 - bad also, all this code...
        showComputeResults(new Compute() {
            @Override
            public int mathOperation(int a, int b) {
                return a * a + b * b;
            }
        });

        //3. Lamba - put directly, great!
        showComputeResults((a, b) -> a - b);
        showComputeResults((a, b) -> a + b);
        showComputeResults((a, b) -> a * b);
        showComputeResults((a, b) -> a / b);
        
        
        //4. Lambda can be keep in simple varaible !! (it's just anonymous object)
        Compute compute = (a, b) -> 1000 + a - b;
        showComputeResults(compute);//lambda zamknieta w zmiennej


        //5. Reference methods - good! Must have definition similar as lambda!
        showComputeResults(Lambda1::myComputeMethod);//metoda o takiej sygnaturze jak potrzebna tu lambda, wywolanie przez method reference
        

        //6. Method that just return lambda! Why not?:)
        showComputeResults(myComputeMethod2());//a to po prostu zwraca potrzebna lambde

        //7. Reference methods - when there is non static. Why not?
        Lambda1 lambda1 = new Lambda1();//A tutaj wywolanie metody niestatycznej/normalnej przez method reference
        lambda1.showComputeResultsNotStatic(lambda1::myComputeMethod3);
    }

    private static int myComputeMethod(int i, int i1) {
        return i * i1 * i * i1;
    }

    private static Compute myComputeMethod2() {
        return (a,b) -> a*a*b*b;
    }

    private int myComputeMethod3(int i, int i1) {
        return i * i1 * i * i1;
    }

    public static void showComputeResults(Compute compute) {
        int i = compute.mathOperation(10, 5);
        System.out.println("i = " + i);
    }

    public void showComputeResultsNotStatic(Compute compute) {
        int i = compute.mathOperation(10, 5);
        System.out.println("i = " + i);
    }
}
