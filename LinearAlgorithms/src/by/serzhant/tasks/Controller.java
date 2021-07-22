package by.serzhant.tasks;

import by.serzhant.tasks.task2.Task02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    private static final String NAME_TASK_2 = "2";
    private static final String NAME_TASK_7 = "7";
    private static final String NAME_TASK_17 = "17";
    private static final String NAME_TASK_22 = "22";
    private static final String NAME_TASK_32 = "32";
    private static final String TASK = "Задача № ";

    public Controller() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            System.out.println(TASK + NAME_TASK_2);
            System.out.println(TASK + NAME_TASK_7);
            System.out.println(TASK + NAME_TASK_17);
            System.out.println(TASK + NAME_TASK_22);
            System.out.println(TASK + NAME_TASK_32);
            System.out.println("0 для выхода");
            System.out.println("Введите номер задачи:");

            switch (reader.readLine()) {
                case NAME_TASK_2:
                    new Task02();
                    break;
                case NAME_TASK_7:
                    System.out.println("Задача 7");
                    break;
                case NAME_TASK_17:
                    System.out.println("Задача 17");
                    break;
                case NAME_TASK_22:
                    System.out.println("Задача 22");
                    break;
                case NAME_TASK_32:
                    System.out.println("Задача 32");
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Ошибка");
                    break;
            }
        }
    }
}
