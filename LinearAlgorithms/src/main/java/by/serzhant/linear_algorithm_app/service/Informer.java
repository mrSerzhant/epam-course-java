package by.serzhant.linear_algorithm_app.service;

import by.serzhant.linear_algorithm_app.executor.Executable;

public class Informer {

    public void printResult(Executable executor) {
        System.out.println("Ответ - " + executor.getResult());
    }
}
