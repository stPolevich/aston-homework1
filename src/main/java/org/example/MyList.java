package org.example;

import java.util.Iterator;
/**
 * Интерфейс, представляющий базовые операции для работы с коллекцией.
 *
 * @param <E> Тип элементов в коллекции.
 */
public interface MyList<E> extends Iterable<E> {

    /**
     * Добавляет элемент в коллекцию.
     *
     * @param element Элемент для добавления.
     * @return возвращает true в случае успешного добавления элемента
     */
    boolean add(E element);

    /**
     * Добавляет элемент по указанному индексу в коллекцию.
     *
     * @param index   Индекс, по которому нужно добавить элемент.
     * @param element Элемент для добавления.
     * @return возвращает true в случае успешного добавления элемента
     * @throws IndexOutOfBoundsException Если индекс выходит за границы коллекции.
     */
    boolean add(int index, E element);

    /**
     * Возвращает элемент по указанному индексу.
     *
     * @param index Индекс элемента.
     * @return Элемент по индексу.
     * @throws IndexOutOfBoundsException Если индекс выходит за границы коллекции.
     */
    E get(int index);

    /**
     * Удаляет первое вхождение указанного элемента из коллекции.
     *
     * @param element Элемент для удаления.
     * @return true, если элемент был найден и удален, в противном случае - false.
     */
    boolean remove(E element);

    /**
     * Удаляет элемент коллекции по индексу.
     *
     * @param index Индекс элемента для удаления.
     * @return возвращает true в случае успешного удаления элемента
     * @throws IndexOutOfBoundsException Если индекс выходит за границы коллекции.
     */
    boolean removeByIndex(int index);

    /**
     * Очищает всю коллекцию.
     */
    void clear();

    /**
     * Возвращает размер коллекции.
     *
     * @return Размер коллекции.
     */
    int size();

    /**
     * Проверяет, пуста ли коллекция.
     *
     * @return true, если коллекция пуста, в противном случае - false.
     */
    boolean isEmpty();
}
