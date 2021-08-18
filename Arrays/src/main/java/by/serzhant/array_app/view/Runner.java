package by.serzhant.array_app.view;

import by.serzhant.array_app.entity.Array;
import by.serzhant.array_app.service.command.InsertionSort;
import by.serzhant.array_app.service.exception.SortException;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) throws SortException {
       //new Menu();

        Double[] ar = {7.0, 12.0, 9.0, 2.0, 4.0, 6.0, 3.0, 8.0, 10.0, 5.0, 1.0, 14.0};

        for(int i = 1; i < ar.length; i++){

            for(int j = i; j >= 0; j--){

                if(ar[i] < ar[i - j]){
                    double tempValue = ar[i - j];
                    ar[i - j] = ar[i];
                    ar[i] = tempValue;

                }
            }
        }











      //  InsertionSort insertionSort = new InsertionSort(new Array<>(ar));

        System.out.println(Arrays.toString(ar));







        }














}






