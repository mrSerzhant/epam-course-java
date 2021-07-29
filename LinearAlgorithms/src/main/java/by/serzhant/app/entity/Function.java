package by.serzhant.app.entity;

public class Function {
    public static final int CONST_ELEMENT = 3;
    private Numeral validNumeral;

    public Function(Numeral numeral){
        validNumeral = numeral;
    }

    public Numeral getValidNumeral() {
        return validNumeral;
    }


}
