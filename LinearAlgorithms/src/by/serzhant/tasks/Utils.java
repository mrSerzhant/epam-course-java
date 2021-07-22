package by.serzhant.tasks;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Utils {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static int isNumber(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            try {
                return Integer.parseInt(reader.readLine());
            }catch (Exception e){
                System.out.println("Неверный формат");
            }
        }




    }

    public static double getInputValue(){
        while (true){
            System.out.println("Введите число:");

            try{
                return Double.parseDouble(reader.readLine());
            }catch (Exception e){
                System.out.println("Ошибка");
            }

        }
    }

    public static void printResult(String str){
        System.out.println(str);
    }









}
