package by.training.demofuncinterface.controller;

import by.training.demofuncinterface.entity.Car;
import by.training.demofuncinterface.entity.UseFoo;

public class Runner {

    private static void printTest(Car car, CheckCar checker) {
        if (checker.test(car)) {
            System.out.println(car + " it is fit");
        } else {
            System.out.println(car + " it is not fit");
        }
    }

    public static void main(String[] args) {
        UseFoo useFoo = new UseFoo();

        System.out.println(useFoo.scopeExperiment());

    }
}


//class Runner{
//    public static void main(String[] args) {
//
//        Consumer<String> con =  new Consumer(){
//            @Override
//            public void accept(final Object newO) {
//                System.out.println(newO);
//            }
//
//        };
//
//        //Consumer<String> con = s -> System.out.println(s);
//        con.accept("Функциональные интерфейсы в Java 8");
//    }
//}

//import java.util.function.*;

//public class Runner{
//    public static void main(String[] args) {
//        BiPredicate<String, String> pred = (s1, s2) -> s1.equals(s2);
//        System.out.println(pred.test("Функциональные интерфейсы", " Функциональные интерфейсы"));
//    }
//}

