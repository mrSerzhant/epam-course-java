package by.serzhant.loop_app.service;

import java.util.List;

public class Validator {
    public boolean isValidInputValue(List<String> inputList) {
        return !inputList.isEmpty();
    }

    public boolean isRealNumeral(int inputNumeral) {
        return inputNumeral > 0;
    }
}
