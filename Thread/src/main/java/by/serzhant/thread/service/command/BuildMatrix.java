package by.serzhant.thread.service.command;

import by.serzhant.thread.dal.DataReader;
import by.serzhant.thread.dal.DataWriter;
import by.serzhant.thread.entity.Matrix;
import by.serzhant.thread.service.validator.Validator;
import by.serzhant.thread.service.parser.Parser;
import by.serzhant.thread.service.thread.ThreadInitMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BuildMatrix implements Command {

    @Override
    public Object execute(){
        DataReader reader = new DataReader();

        List<String> dataList = reader.readMatrixDataFile();
        List<String> threadList = reader.readThreadDataFile();

        Validator validator = new Validator();

        if (!validator.isValidMatrixData(dataList)) {
            return "invalid data matrix";
        }


        if (!validator.isValidCountElement(threadList)) {
            return "invalid thread";
        }

        Parser parser = new Parser();

        List<Integer> listThreadLimit = parser.parseDiapason(threadList.get(0));
        int firstLimit = listThreadLimit.get(0);
        int secondLimit = listThreadLimit.get(1);

        int countThread = find(firstLimit, secondLimit);
        int sizeMatrix = Integer.parseInt(dataList.get(0));

        ExecutorService service = Executors.newFixedThreadPool(countThread);
        Integer[][] matrix = new Integer[sizeMatrix][sizeMatrix];

        List<ThreadInitMatrix> list = new ArrayList<>();
        for (int i = 1; i < dataList.size(); i++) {
            list.add(new ThreadInitMatrix(matrix, i, dataList));
        }

        try {
            service.invokeAll(list);
        } catch (Exception e) {
            return "bad_result";
        }

        service.shutdown();

        DataWriter writer = new DataWriter();
        writer.writeTempData(matrix);
        writer.writeTempThreadData(countThread);

        return new Matrix(matrix);
    }

    private int find(int firstLimit, int secondLimit) {
        return firstLimit + (int) (Math.random() * ((secondLimit - firstLimit) + 1));
    }
}
