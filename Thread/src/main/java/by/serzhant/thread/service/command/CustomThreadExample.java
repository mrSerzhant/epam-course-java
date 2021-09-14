package by.serzhant.thread.service.command;

import by.serzhant.thread.dal.DataReader;
import by.serzhant.thread.entity.Matrix;
import by.serzhant.thread.service.thread.ThreadCustom;
import by.serzhant.thread.service.parser.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CustomThreadExample implements Command{
    @Override
    public Object execute()  {
        DataReader reader = new DataReader();
        Parser parser = new Parser();

        Integer[][] tempMatrix = parser.parseTempMatrixElement(reader.readMatrixTempDataFile());
        int countThread = Integer.parseInt(reader.readThreadTempDataFile().get(0));

        Matrix matrix = new Matrix(tempMatrix);

        ExecutorService service = Executors.newFixedThreadPool(countThread);

        List<ThreadCustom> list = new ArrayList<>();

        for(int i = 0; i  < matrix.getRowLength(); i++){
            list.add(new ThreadCustom(matrix,i));
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
