package by.it.samatokhin.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[0];
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size--] = null;
        return element;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                out.add(elements[i].toString());
            } else {
                out.add("null");
            }
        }
        return out.toString();
    }

    @Override
    public T set(int i, T t) {
        T element = elements[i];
        elements[i] = t;
        return element;
    }

    @Override
    public void add(int i, T t) {

        T[] newElements = (T[]) new Object[size + 1];

        for (int x = 0; x < newElements.length; x++) {
            if (x < i) {
                newElements[x] = elements[x];
            } else if (x == i) {
                newElements[x] = t;
            } else {
                newElements[x] = elements[x - 1];
            }
        }
        size++;
        elements = Arrays.copyOf(newElements, size);
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {

        List<T> tempLst = (List<T>) collection;
        T[] newElements = (T[]) new Object[elements.length + tempLst.size()];

        for (int x = 0; x < elements.length; x++) {
            newElements[x] = elements[x];

        }
        for (int x = 0; x < tempLst.size(); x++) {
            newElements[elements.length + x] = tempLst.get(x);
        }
        size = elements.length + tempLst.size();
        elements = Arrays.copyOf(newElements, size);
        return false;
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
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] t1s) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
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
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }
}
