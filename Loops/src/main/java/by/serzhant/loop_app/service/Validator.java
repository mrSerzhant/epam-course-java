package by.serzhant.loop_app.service;

import java.util.List;

public class Validator {
    public boolean isValidInputValue(List<String> inputList) {
        return !inputList.isEmpty();
    }

    public boolean isRealNumeral(int inputNumeral) {
        if (inputNumeral > 0) {
            return true;
        }

        return false;
    }
}
