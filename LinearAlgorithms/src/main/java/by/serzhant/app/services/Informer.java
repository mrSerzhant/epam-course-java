package by.serzhant.app.services;

import by.serzhant.app.executers.Executable;

public class Informer {


    public void printResult(Executable executor){
        System.out.println("Ответ - " + executor.getResult());
    }


}
