package by.serzhant.tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
    private static final String errorMessage = "Ошибка";
    private static final String inputMessage = "Введите число:";

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static double getInputValue(){
        while (true){
            System.out.println(inputMessage);

            try{
                return Double.parseDouble(reader.readLine());
            }catch (Exception e){
                System.out.println(errorMessage);
            }

        }
    }

    public static int getInputNaturalValue(){
        int tempValue;

        while (true){
            System.out.println(inputMessage);

            try{
                tempValue = Integer.parseInt(reader.readLine());

                if(tempValue >= 1) {
                    return tempValue;
                }

                System.out.println(errorMessage);
            }catch (Exception e){
                System.out.println(errorMessage);
            }

        }
    }

    public static void printResult(String str){
        System.out.println(str+"\n");
    }
}
