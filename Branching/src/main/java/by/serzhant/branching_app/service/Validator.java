package by.serzhant.branching_app.service;

import java.util.List;

public class Validator {
    public static final String ERROR_MESSAGE = "Неверные входные данные";


    public boolean isValidInputValue(List<String> inputList) {
        return !inputList.isEmpty();
    }




}
