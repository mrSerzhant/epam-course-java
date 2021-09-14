package by.serzhant.thread.service.command;

import by.serzhant.thread.dal.DataReader;
import by.serzhant.thread.entity.Matrix;
import by.serzhant.thread.service.parser.Parser;
import by.serzhant.thread.service.thread.ThreadSemaphore;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreExample implements Command {
    @Override
    public Object execute()  {
        DataReader reader = new DataReader();
        Parser parser = new Parser();

        Integer[][] tempMatrix = parser.parseTempMatrixElement(reader.readMatrixTempDataFile());
        int countThread = Integer.parseInt(reader.readThreadTempDataFile().get(0));

        Matrix matrix = new Matrix(tempMatrix);

        Semaphore semaphore = new Semaphore(1,true);

        ExecutorService service = Executors.newFixedThreadPool(countThread);

        List<ThreadSemaphore> list = new ArrayList<>();
        for(int i = 0; i  < matrix.getRowLength(); i++){
            list.add(new ThreadSemaphore(semaphore,matrix,i));
        }

        try {
            service.invokeAll(list);
        }catch (Exception e){

            return "bad_result";
        }

        service.shutdown();

        return matrix;
    }
}
