package store;

import model.IWeight;

import java.util.Arrays;

public class AbstractStore {
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
        for(int i = 0;i < count;i++){
            sb.append(arr[i]).append("\n");
        }
        return sb.toString();
    }
}
