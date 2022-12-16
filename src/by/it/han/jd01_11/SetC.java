package by.it.han.jd01_11;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private T[] elements = (T[]) new Object[0];

    private int size = 0;

    private boolean setHasNull = false;

    @Override
    public boolean add(T t) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, size * 3 / 2 + 1);
        }
        for (T element : elements) {
            if (t == null && !setHasNull) {
                setHasNull = true;
                break;
            } else if (t == null) {
                return true;
            } else if (t.equals(element)) {
                return true;
            }
        }
        elements[size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] == (o)) {
                System.arraycopy(elements, i + 1, elements, i, size - i);
                elements[--size] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (T element : elements) {
            if (element == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        for (T t : collection) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        boolean isContains = false;
        for (Object o : collection) {
            isContains = contains(o);
        }
        return isContains;
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        for (Object o : collection) {
            remove(o);
        }
        return true;
    }

    @Override
    public void clear() {
        elements = (T[]) new Object[0];
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    //-----------------------------------------------------

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }
}
