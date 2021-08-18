package by.serzhant.array_app.entity;

import java.util.Arrays;

public class Array <T extends Number> {
    private T[] array;
    private int length;

    public Array(T[] array){
        this.array = array;
        this.length = array.length;
    }

    public T[] getArray() {
        return array;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Array<?> array1 = (Array<?>) o;
        return Arrays.equals(array, array1.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
