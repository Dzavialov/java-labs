package store;

import model.AbstractForm;
import model.IWeight;
import model.Timber;

import java.util.Arrays;

public class ProductStore extends AbstractStore {


    public void add(IWeight newProduct) {
        if(arr.length == count)
            arr = Arrays.copyOf(arr,count + count/2);
        arr[count++] = newProduct;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Вміст сховища продуктів:\n");
        sb.append(super.toString());
        return sb.toString();
    }
}
