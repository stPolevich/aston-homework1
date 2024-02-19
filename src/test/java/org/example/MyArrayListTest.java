package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest {

    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());

        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
        assertEquals(1, (int) list.get(0));

        list.add(2);
        assertEquals(2, list.size());
        assertEquals(2, (int) list.get(1));
    }

    @Test
    public void testAddAtIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("three");
        list.add(1, "two");
        assertEquals(3, list.size());
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
    }

    @Test
    public void testGetForInvalidIndex() {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("one");
        list.add("two");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(3);
        });
    }

    @Test
    public void testRemove() {
        MyArrayList<Double> list = new MyArrayList<>();
        list.add(1.0);
        list.add(2.0);
        list.add(3.0);
        assertTrue(list.remove(2.0));
        assertEquals(2, list.size());
        assertFalse(list.remove(4.0));
        assertEquals(2, list.size());
    }

    @Test
    public void testClear() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testSize() {
        MyArrayList<Character> list = new MyArrayList<>();
        assertEquals(0, list.size());

        list.add('a');
        assertEquals(1, list.size());

        list.add('b');
        assertEquals(2, list.size());

        list.remove('a');
        assertEquals(1, list.size());
    }

    @Test
    public void testQuickSort() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        list.add(1);
        list.add(5);

        list.quickSort();

        assertEquals(1, (int) list.get(0));
        assertEquals(1, (int) list.get(1));
        assertEquals(3, (int) list.get(2));
        assertEquals(4, (int) list.get(3));
        assertEquals(5, (int) list.get(4));
    }
}