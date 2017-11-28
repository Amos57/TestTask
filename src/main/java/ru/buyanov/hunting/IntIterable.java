package ru.buyanov.hunting;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  @author https://github.com/alex-on-java 03.02.2016
 */
public class IntIterable implements Iterable<Integer> {

    int[] backed; //основной массив

    int lenght; // длина


    public IntIterable(int[] backed) {

        this.backed = backed;
        lenght=backed.length;
    }

    //
    public Iterator<Integer> iterator() {
        return new IntIterator();
    }



    private class IntIterator implements Iterator<Integer> {


        int index;   //инекс каждого элемента


        /**
         *условие для цикла
         * @return возвращает true если в коллекции есть следующий элемент
         */
        public boolean hasNext() {
        return index!=lenght;
        }

        /**
         * процесс итерации
         * @return каждый элемент массива
         */
        public Integer next() {

           int i = index;

            index=i+ 1;

            return  backed[i];
        }

        public void remove() {
            throw new IllegalStateException("Could not remove from array");
        }
    }
}
