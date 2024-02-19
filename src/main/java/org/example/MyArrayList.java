package org.example;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Реализация интерфейса main.java.org.example.MyList с использованием динамического массива.
 *
 * @param <E> Тип элементов в списке.
 */

public class MyArrayList<E extends Comparable<E>> implements MyList<E> {
    /**
     * Начальная емкость списка по умолчанию.
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Массив элементов списка.
     */
    private Object[] elements;

    /**
     * Размер списка (количество элементов, добавленных в список).
     */
    private int size;


    /**
     * Конструктор без параметров, создает список с начальной емкостью 10 элементов.
     */
    public MyArrayList(){
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    /**
     * Конструктор с параметром, создает список с заданной начальной емкостью элементов.
     *
     * @param customCapacity пользовательский размер массива.
     */
    public MyArrayList(int customCapacity){
        this.elements = new Object[customCapacity];
    }

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element Элемент для добавления.
     */
    @Override
    public boolean add(E element) {
        ensureCapacity();
        elements[size++] = element;
        return true;
    }

    /**
     * Добавляет элемент по указанному индексу в список.
     *
     * @param index   Индекс, по которому нужно добавить элемент.
     * @param element Элемент для добавления.
     * @throws IndexOutOfBoundsException Если индекс выходит за границы списка.
     */
    @Override
    public boolean add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;

        return true;
    }

    /**
     * Получает элемент по указанному индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент по индексу.
     * @throws IndexOutOfBoundsException Если индекс выходит за границы списка.
     */
    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    /**
     * Удаляет первое вхождение указанного элемента из списка.
     *
     * @param element Элемент для удаления.
     * @return true, если элемент был найден и удален, в противном случае - false.
     */
    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (element.equals(elements[i])){
                removeAtIndex(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Удаляет указанный элемент из списка по индексу.
     *
     * @param index Индекс для удаления элемента.
     * @return true, если элемент был найден и удален
     * @throws IndexOutOfBoundsException Если индекс выходит за границы списка.
     */
    @Override
    public boolean removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        removeAtIndex(index);
        return true;
    }

    /**
     * Очищает всю коллекцию, устанавливая размер в 0.
     */
    @Override
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Возвращает размер списка.
     *
     * @return Размер списка.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Проверяет, пуст ли список.
     *
     * @return true, если список пуст, в противном случае - false.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index Индекс элемента для удаления.
     */
    private void removeAtIndex(int index){
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
    }

    /**
     * Проверяет и увеличивает емкость списка, если необходимо.
     */
    private void ensureCapacity() {
        if (size == elements.length){
            elements = Arrays.copyOf(elements, elements.length + (elements.length >> 1) + 1);
        }
    }

    /**
     * Возвращает итератор для обхода элементов списка.
     *
     * @return Итератор для списка.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elements[currentIndex] != null;
            }

            @Override
            public E next() {
                return (E) elements[currentIndex++];
            }
        };
    }


    /**
     * Публичный метод осуществляющий быструю сортировку.
     */
    public void quickSort() {
        quickSort(0, size - 1);
    }

    /**
     * Рекурсивный метод быстрой сортировки.
     *
     * @param low  Нижний индекс текущего подсписка.
     * @param high Верхний индекс текущего подсписка.
     */
    private void quickSort(int low, int high) {
        if (low < high) {
            int partitionIndex = partition(low, high);
            quickSort(low, partitionIndex - 1);
            quickSort(partitionIndex + 1, high);
        }
    }

    /**
     * Разбивает массив на две части относительно опорного элемента.
     *
     * @param low  Нижний индекс текущего подсписка.
     * @param high Верхний индекс текущего подсписка.
     * @return Индекс опорного элемента после завершения разбиения.
     */
    private int partition(int low, int high) {
        E pivot = get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (get(j).compareTo(pivot) <= 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return i + 1;
    }

    /**
     * Обменивает значения между двумя индексами в массиве.
     *
     * @param i Индекс первого элемента.
     * @param j Индекс второго элемента.
     */
    private void swap(int i, int j) {
        E temp = get(i);
        elements[i] = elements[j];
        elements[j] = temp;
    }
}

