package by.it.han.jd01_11;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SetC<T> implements Set<T> {

    private final HashMap<T, Object> map;

    private int size = 0;

    public SetC() {
        this.map = new HashMap<>();
    }

    private static final Object PRESENT = new Object();

    @Override
    public boolean add(T t) {
        size++;
        return map.put(t, PRESENT) == null;
    }

    @Override
    public boolean remove(Object o) {
        return map.remove(o) == PRESENT;
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public int size() {
        return map.size();
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
        for (Object o : collection) {
            contains(o);
        }
        return true;
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
        map.clear();
    }

    @Override
    public String toString() {
        return map.keySet().toString();
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
