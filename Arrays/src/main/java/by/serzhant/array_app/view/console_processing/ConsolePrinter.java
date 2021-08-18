package by.serzhant.array_app.view.console_processing;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.view.locale.MessageManager;

public class ConsolePrinter {
    private static final String BUBBLE_SORT = "bubble_sort";
    private static final String SHAKER_SORT = "shaker_sort";
    private static final String SELECTION_SORT = "selection_sort";
    private static final String INSERTION_SORT = "insertion_sort";
    private static final String MERGE_SORT = "merge_sort";
  //  private static final String TASK = "task_number";

    private String invalidArgumentMessage;
    private MessageManager messageManager;

    public ConsolePrinter(String inputValue) {

        while (true) {
            switch (inputValue) {
                case "1":
                    messageManager = MessageManager.RU;
                    invalidArgumentMessage = messageManager.getString("invalid_argument_message");
                    System.out.println(messageManager.getString("success_set_language"));
                    return;
                case "2":
                    messageManager = MessageManager.EN;
                    invalidArgumentMessage = messageManager.getString("invalid_argument_message");
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
        System.out.println(messageManager.getString("press_to_exit") + "\n");
        System.out.println(messageManager.getString("press_to_choice"));
    }

    public String getInvalidArgumentMessage() {
        return invalidArgumentMessage;
    }

    public void printResult(Object inputObject) {

        if(inputObject instanceof Array){

            for(Number object: ((Array<?>) inputObject).getArray()){
                System.out.print(object);

            }


        }else{

            System.out.println(inputObject.toString());

        }





        //System.out.println(messageManager.getString("result_info") + messageManager.getString(inputObject.toString()));
    }

    public void printExitMessage() {
        System.out.println(messageManager.getString("exit_info"));
    }
}
