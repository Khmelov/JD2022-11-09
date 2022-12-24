package by.it.cherny.jd01_11;

import java.util.*;

public class ListB<T> implements List<T> {

    @SuppressWarnings("unchecked")
    private T[] elements = (T[]) new Object[16];
    private int size = 0;

    @Override
    public boolean add(T element) {
        if (size==elements.length){
            elements = Arrays.copyOf(elements, elements.length * 3 / 2 + 1);
        }
        elements[size++]=element;
        return true;
    }

    @Override
    public T remove(int index) {
        T element = elements[index];
        System.arraycopy(elements, index+1,elements,index, size-index-1);
        elements[size--]=null;
        return element;
    }

    @Override
    public T get(int index) {
        return elements[index];
    }

    @Override
    public T set(int index, T element) {
        T element1 = elements[index];
        elements[index]=element;
        return element1;
    }

    @Override
    public void add(int index, T element) {
        T[] newArray = (T[]) new Object[elements.length+1];
        System.arraycopy(elements, 0,newArray,0, index);
        newArray[index]=element;
        size++;
        System.arraycopy(elements, index,newArray,index+1, elements.length-index-1);
        elements = Arrays.copyOf(newArray, newArray.length);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        T[] newArray = (T[]) new Object[elements.length+c.size()];
        System.arraycopy(c.toArray(), 0,newArray,size, c.size());
        System.arraycopy(elements, 0,newArray,0, size);
        size+=c.size();
        elements = Arrays.copyOf(newArray, newArray.length);
        return true;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "[", "]");
        for (int i = 0; i < size; i++) {
            if (elements[i]==null){
                out.add("null");
                continue;
            }
            out.add(elements[i].toString());
        }
        return out.toString();
    }

    //-------------------------------------------------
    @Override
    public int size() {
        return 0;
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
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

//    @Override
//    public boolean addAll(Collection<? extends T> c) {
//        return false;
//    }

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
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
