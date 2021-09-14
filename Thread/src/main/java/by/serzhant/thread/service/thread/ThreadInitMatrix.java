package by.serzhant.thread.service.thread;

import java.util.List;
import java.util.concurrent.Callable;

public class ThreadInitMatrix implements Callable<String> {
    private Integer[][] matrix;
    private int index;
    private List<String> list;

    public ThreadInitMatrix(Integer[][] matrix, int index, List<String> list){
        this.matrix = matrix;
        this.index = index;
        this.list = list;
    }

    @Override
    public String call() {
        String[] arrayStrings = list.get(index).split(" ");

        for (int j = 0; j < arrayStrings.length; j++) {

            try {
                matrix[index-1][j] = Integer.parseInt(arrayStrings[j]);
            } catch (NumberFormatException e) {
            }
        }

        return "done";
    }
}
