package by.serzhant.thread.view.console_processing;

import by.serzhant.thread.view.locale.MessageManager;

public class ConsolePrinter {
    private static final String BUILD_MATRIX = "build_matrix";
    private static final String SEMAPHORE = "semaphore";
    private static final String REENTRANT_LOCKER = "reentrant_locker";
    private static final String CUSTOM = "custom";

    private MessageManager messageManager;

    /**
     Класс отвечает за выбор локали и вывода на экран информации в зависимости от вида локали
     */

    public ConsolePrinter(String inputValue) {

        while (true) {
            switch (inputValue) {
                case "1":
                    messageManager = MessageManager.RU;
                    System.out.println(messageManager.getString("success_set_language"));
                    return;
                case "2":
                    messageManager = MessageManager.EN;
                    System.out.println(messageManager.getString("success_set_language"));
                    return;
                default:
                    System.exit(0);
            }
        }
    }

    public static void printSetLanguageInfo() {
        System.out.println("Русский - нажмите 1");
        System.out.println("English - press 2");
        System.out.println("Exit - 0");
    }


    /**
     Данный метод выводит меню в консоль
     */

    public void printMenu() {
        System.out.println(messageManager.getString(BUILD_MATRIX));
        System.out.println(messageManager.getString(SEMAPHORE));
        System.out.println(messageManager.getString(REENTRANT_LOCKER));
        System.out.println(messageManager.getString(CUSTOM));
        System.out.println(messageManager.getString("press_to_exit") + "\n");
        System.out.println(messageManager.getString("press_to_choice"));
    }


    /**
     Данный метод меняет язык и выводит результут выполнения программы в консоль
     */

    public void printResult(Object inputObject) {
        System.out.println(messageManager.getString("result_info") + messageManager.getString(inputObject.toString()) + "\n");
    }

    /**
     Данный метод информирует о завершении работы программы
     */

    public void printExitMessage() {
        System.out.println(messageManager.getString("exit_info"));
    }
}
