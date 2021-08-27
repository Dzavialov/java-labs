package store;

import model.IWeight;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AbstractStore implements java.io.Serializable, Iterable <Object> {
    protected int count = 0;
    protected Object[] arr = new Object[3];

    public Object[] getArr() {
        return Arrays.copyOf(arr,count);
    }

    protected void add(Object newObject) {
        if(arr.length == count)
            arr = Arrays.copyOf(arr,count + count/2);
        arr[count++] = newObject;
    }

    public int getCount(){
        return count;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(Object obj : this)
            sb.append(obj).append("\n");
        return sb.toString();
    }

    @Override
    public Iterator<Object> iterator() {
        return new StoreIterator();
    }

    public ListIterator<Object> listIterator(){
        return new ListStoreIterator();
    }

    private class StoreIterator implements Iterator <Object> {
        //індекс поточного елеманту масиву arr
        int current = 0;
        @Override
        public boolean hasNext(){
            //count - це кількість елементів у масиві
            return current < count;
        }

        @Override
        public Object next() {
            return arr[current++];
        }

        @Override
        public void remove(){
            System.arraycopy(arr,current,arr,current - 1, count-- -current--);
        }
    }

    private class ListStoreIterator extends StoreIterator implements ListIterator <Object> {
        @Override
        public boolean hasPrevious(){
            return current > 0;
        }

        @Override
        public Object previous() {
            return arr[current--];
        }

        @Override
        public int nextIndex() {
            return current+1;
        }

        @Override
        public int previousIndex(){
            return current-1;
        }

        @Override
        public void set(Object o){
            arr[current] = 0;
        }

        @Override
        public void add(Object o) {
            if(current == arr.length-1) {
                arr = Arrays.copyOf(arr,arr.length+1);
                System.arraycopy(arr,current,arr,current+1,count - current);
                arr[current] = 0;
                current++;
                count++;
            }
        }
    }
}
