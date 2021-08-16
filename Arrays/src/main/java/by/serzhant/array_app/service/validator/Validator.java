package by.serzhant.array_app.service.validator;

import java.util.List;

public class Validator {

    public boolean isValidInputValue(List<String> inputList) {
        return inputList == null || inputList.isEmpty();
    }
}
