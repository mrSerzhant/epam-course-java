package by.serzhant.tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {

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






}
