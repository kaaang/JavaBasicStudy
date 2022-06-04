package chapter3.section5;

import java.util.Arrays;

public class MyArrayList<E> {
    private static final int INIT_CAPACITY = 10;
    private E [] theData;
    private int size;
    private int capacity = INIT_CAPACITY;

    public MyArrayList(){
        theData = (E []) new Object[INIT_CAPACITY];
        size = 0;
    }

    public void add(int index, E anEntity){
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);

        }

        if(size >= capacity){
            reallocate();
        }

        for(int i=size-1; i>=index; i--){
            theData[i+1] = theData[i];
        }
        theData[index] = anEntity;
        size++;

    }

    public void add(E enEntry){
        add(size, enEntry);
    }

    public int indexOf(E anEntry){
        for(int i=0;i<size;i++){
            if(theData[i].equals(anEntry))
                return i;
        }
        return -1;
    }

    private void reallocate() {
        capacity *= 2;
        theData = Arrays.copyOf(theData, capacity);
    }
}
