package by.serzhant.branching_app.view;

public class Printer {
    private static final String NAME_TASK_2 = "2";
    private static final String NAME_TASK_7 = "7";
    private static final String NAME_TASK_17 = "17";
    private static final String NAME_TASK_22 = "22";
    private static final String NAME_TASK_32 = "32";
    private static final String TASK = "Задача № ";
    public static final String NOT_VALID_ARGUMENT = "Неверный аргумент";

    public void printMenu(){
        System.out.println(TASK + NAME_TASK_2);
        System.out.println(TASK + NAME_TASK_7);
        System.out.println(TASK + NAME_TASK_17);
        System.out.println(TASK + NAME_TASK_22);
        System.out.println(TASK + NAME_TASK_32);
        System.out.println("0 для выхода");
        System.out.println("Введите номер задачи:");
    }

    public void printResult(Object inputObject){
        System.out.println("Результат: " +  inputObject);
    }

    public String getResult(Object inputObject){
        return inputObject.toString();
    }

    public void printExitMessage(){
        System.out.println("Завершение работы");
    }

}
