package by.it.cherny.jd01_11;

import java.util.*;

public class SetC<T> implements Set<T> {
    private TreeSet elements = new TreeSet();
    int size = elements.size();
    @Override
    public boolean add(T element) {
        elements.add(element);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (elements.contains(o.toString())){
            elements.remove(o);
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        if (elements.contains(0)){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return elements.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        elements.addAll(c);
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        elements.removeAll(c);
        return true;
    }

    @Override
    public String toString() {
//        StringBuilder out = new StringBuilder();
//        Object[] array = elements.toArray();
//        out.append("[");
//        for (int i = 0; i < size; i++) {
//            if (i != size-1){
//                out.append(array[i]).append(", ");
//            } else {
//                out.append(array[i]);
//            }
//        }
//        out.append("]");
//        return out.toString();
        return elements.toString();
    }

    //----------------------------------

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

    @Override
    public void clear() {

    }
}
