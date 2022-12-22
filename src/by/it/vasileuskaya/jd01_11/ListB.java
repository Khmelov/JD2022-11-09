package by.it.vasileuskaya.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {
    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[0];
    private int size = 0;

    @Override
    public String toString() {
        StringJoiner stringOut = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                stringOut.add(elements[i].toString());
            } else {
                stringOut.add("null");
            }
        }
        return stringOut.toString();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return elements;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(this.elements, this.elements.length * 3 / 2 + 1);
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] arrayNew = (T[]) c.toArray();

        if ((elements.length - size) < arrayNew.length) {
            elements = Arrays.copyOf(elements, (elements.length + (arrayNew.length - (elements.length - size))));
        }
        System.arraycopy(arrayNew, 0, elements, size, arrayNew.length);
        size += c.size();
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T previousValue = elements[index];
        elements[index] = element;

        return previousValue;
    }

    @Override
    public void add(int index, T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(this.elements, this.elements.length * 3 / 2 + 1);
        }
        if (!(index > size || index < 0)) {
            size++;
            System.arraycopy(elements, index, elements, index + 1, size - index);
            elements[index] = element;

        } else {
            System.out.println("Wrong");
        }
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size--] = null;
        return element;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < elements.length; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
