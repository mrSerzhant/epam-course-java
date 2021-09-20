package by.serzhant.figure.repository;

public class FigureRepository implements Repository {
    private static FigureRepository repository;

    public static FigureRepository getRepository() {
        if (repository == null) {
            repository = new FigureRepository();
        }
        return repository;
    }


    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void change() {

    }
}
