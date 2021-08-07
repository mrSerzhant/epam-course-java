package by.serzhant.branching_app.view;

public class ConsolePrinter {
    private static final String NAME_TASK_2 = "2";
    private static final String NAME_TASK_7 = "7";
    private static final String NAME_TASK_17 = "17";
    private static final String NAME_TASK_22 = "22";
    private static final String NAME_TASK_32 = "32";
    private static final String TASK = "task_number";

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
        System.out.println(messageManager.getString(TASK) + NAME_TASK_2);
        System.out.println(messageManager.getString(TASK) + NAME_TASK_7);
        System.out.println(messageManager.getString(TASK) + NAME_TASK_17);
        System.out.println(messageManager.getString(TASK) + NAME_TASK_22);
        System.out.println(messageManager.getString(TASK) + NAME_TASK_32);
        System.out.println(messageManager.getString("press_to_exit") + "\n");
        System.out.println(messageManager.getString("press_to_choice"));
    }

    public String getInvalidArgumentMessage() {
        return invalidArgumentMessage;
    }

    public void printResult(Object inputObject) {
        System.out.println(messageManager.getString("result_info") + messageManager.getString(inputObject.toString()));
    }

    public void printExitMessage() {
        System.out.println(messageManager.getString("exit_info"));
    }
}
