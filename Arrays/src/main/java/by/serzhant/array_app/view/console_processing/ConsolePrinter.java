package by.serzhant.array_app.view.console_processing;

import by.serzhant.array_app.view.locale.MessageManager;

public class ConsolePrinter {
    private static final String BUBBLE_SORT = "bubble_sort";
    private static final String SHAKER_SORT = "shaker_sort";
    private static final String SELECTION_SORT = "selection_sort";
    private static final String INSERTION_SORT = "insertion_sort";
    private static final String MERGE_SORT = "merge_sort";
    private static final String SHELL_SORT = "shell_sort";
    private static final String HASH_SORT = "hash_sort";
    private static final String SUM_MATRIX = "sum_matrix";
    private static final String SUBTRACT_MATRIX = "subtract_matrix";
    private static final String MULTI_MATRIX = "multi_matrix";

    private MessageManager messageManager;

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

    public void printMenu() {
        System.out.println(messageManager.getString(BUBBLE_SORT));
        System.out.println(messageManager.getString(SHAKER_SORT));
        System.out.println(messageManager.getString(SELECTION_SORT));
        System.out.println(messageManager.getString(INSERTION_SORT));
        System.out.println(messageManager.getString(MERGE_SORT));
        System.out.println(messageManager.getString(SHELL_SORT));
        System.out.println(messageManager.getString(HASH_SORT));
        System.out.println(messageManager.getString(SUM_MATRIX));
        System.out.println(messageManager.getString(SUBTRACT_MATRIX));
        System.out.println(messageManager.getString(MULTI_MATRIX));
        System.out.println(messageManager.getString("press_to_exit") + "\n");
        System.out.println(messageManager.getString("press_to_choice"));
    }

    public void printResult(Object inputObject) {
        System.out.println(messageManager.getString("result_info") + messageManager.getString(inputObject.toString()) + "\n");
    }

    public void printExitMessage() {
        System.out.println(messageManager.getString("exit_info"));
    }
}
