package by.serzhant.service.thread;

import by.serzhant.thread.entity.Matrix;
import by.serzhant.thread.service.command.CustomThreadExample;
import by.serzhant.thread.service.thread.ThreadCustom;
import by.serzhant.thread.service.thread.ThreadInitMatrix;
import by.serzhant.thread.service.thread.ThreadReentrantLock;
import by.serzhant.thread.service.thread.ThreadSemaphore;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    @DataProvider(name = "data-not-equals")
    public Object[][] dataProviderThread() {
        Integer[][] matrix = {{0, 5, -2}, {2, 0, -4}, {-3, 5, 0}};

        return new Object[][]{{new Matrix(matrix)}};
    }

    @DataProvider(name = "init-matrix-equals")
    public Object[][] dataProviderInitMatrix() {
        List<String> dataList = new ArrayList<>();
        dataList.add("3");
        dataList.add("0 5 -2");
        dataList.add("2 0 -4");
        dataList.add("3 5 0");

        return new Object[][]{{dataList}};
    }

    @Test(dataProvider = "init-matrix-equals")
    public void initMatrixThreadTest(List<String> inputData) {
        Integer[][] m1 = {{0,5,-2},{2,0,-4},{3,5,0}};
        Matrix matrix1 = new Matrix(m1);

        Integer[][] m2 = new Integer[inputData.size()-1][inputData.size()-1];

        ExecutorService service = Executors.newFixedThreadPool(inputData.size()-1);

        List<ThreadInitMatrix> list = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            list.add(new ThreadInitMatrix(m2, i, inputData));
        }

        try {
            service.invokeAll(list);
        } catch (Exception e) {
        }

        service.shutdown();

        Matrix matrix2 = new Matrix(m2);

        Assert.assertEquals(matrix1,matrix2);
    }

    @Test(dataProvider = "data-not-equals")
    public void reentrantLockThreadTest(Matrix inputMatrix) {
        List<Integer> listElement = new ArrayList<>();
        listElement.add(inputMatrix.getElement(0));
        listElement.add(inputMatrix.getElement(1));
        listElement.add(inputMatrix.getElement(2));

        ReentrantLock locker = new ReentrantLock();

        ExecutorService service = Executors.newFixedThreadPool(inputMatrix.getRowLength());

        List<ThreadReentrantLock> list = new ArrayList<>();
        list.add(new ThreadReentrantLock(locker,inputMatrix,0));
        list.add(new ThreadReentrantLock(locker,inputMatrix,0));
        list.add(new ThreadReentrantLock(locker,inputMatrix,0));

        try {
            service.invokeAll(list);
        }catch (Exception e){
        }

        service.shutdown();

        List<Integer> newListElement = new ArrayList<>();
        newListElement.add(inputMatrix.getElement(0));
        newListElement.add(inputMatrix.getElement(1));
        newListElement.add(inputMatrix.getElement(2));

        Assert.assertNotEquals(listElement,newListElement);
    }

    @Test(dataProvider = "data-not-equals")
    public void semaphoreThreadTest(Matrix inputMatrix) {
        List<Integer> listElement = new ArrayList<>();
        listElement.add(inputMatrix.getElement(0));
        listElement.add(inputMatrix.getElement(1));
        listElement.add(inputMatrix.getElement(2));

        Semaphore semaphore = new Semaphore(1,true);
        ExecutorService service = Executors.newFixedThreadPool(inputMatrix.getRowLength());

        List<ThreadSemaphore> list = new ArrayList<>();
        list.add(new ThreadSemaphore(semaphore,inputMatrix,0));
        list.add(new ThreadSemaphore(semaphore,inputMatrix,0));
        list.add(new ThreadSemaphore(semaphore,inputMatrix,0));

        try {
            service.invokeAll(list);
        }catch (Exception e){
        }

        service.shutdown();

        List<Integer> newListElement = new ArrayList<>();
        newListElement.add(inputMatrix.getElement(0));
        newListElement.add(inputMatrix.getElement(1));
        newListElement.add(inputMatrix.getElement(2));

        Assert.assertNotEquals(listElement,newListElement);
    }

    @Test(dataProvider = "data-not-equals")
    public void customThreadTest(Matrix inputMatrix) {
        List<Integer> listElement = new ArrayList<>();
        listElement.add(inputMatrix.getElement(0));
        listElement.add(inputMatrix.getElement(1));
        listElement.add(inputMatrix.getElement(2));

        ExecutorService service = Executors.newFixedThreadPool(inputMatrix.getRowLength());

        List<ThreadCustom> list = new ArrayList<>();

        list.add(new ThreadCustom(inputMatrix,0));
        list.add(new ThreadCustom(inputMatrix,1));
        list.add(new ThreadCustom(inputMatrix,2));

        try {
            service.invokeAll(list);
        }catch (Exception e){
        }

        service.shutdown();

        List<Integer> newListElement = new ArrayList<>();
        newListElement.add(inputMatrix.getElement(0));
        newListElement.add(inputMatrix.getElement(1));
        newListElement.add(inputMatrix.getElement(2));

        CustomThreadExample c = new CustomThreadExample();

        Assert.assertNotEquals(listElement,newListElement);
    }





}
