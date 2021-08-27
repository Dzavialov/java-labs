package test;

import model.Wood;

import javax.swing.*;
import java.util.*;

public class TestCollections {
    Random rnd = new Random();
    public void main() {
        one();
        two();
        three();
        five();
        six();
    }

    public void one() {
        Collection<Integer> c1 = new Vector<>();
        for (int i = 0; i < 15; i++) {
            c1.add(rnd.nextInt(10));
        }
        System.out.println("Collection vector");
        for(Integer x : c1)
            System.out.printf("%d ", x);
        Collection<Integer> c2 = new TreeSet<>();
        c2.addAll(c1);
        System.out.println("\nCollection TreeSet");
        c2.forEach((x)-> System.out.printf("%d ", x));
    }

    public void two(){
        Collection<Integer> c1 = new ArrayList<>();
        Collection<Integer> c2 = new LinkedHashSet<>();
        Collection<Integer> c3 = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            c1.add(rnd.nextInt(10));
            c2.add(rnd.nextInt(10));
        }
        System.out.println();

        System.out.println("Numbers that are in the first collection, and not in the second");
        c3.addAll(c1); c3.remove(c2);
        System.out.println(c1 + "removeAll" + c2 + "=" + c3 );

        System.out.println("Numbers that are in the second collection, and not in the first");
        c3.clear();c3.addAll(c2);c3.removeAll(c1);
        System.out.println(c2+"removeAll"+c1+ " = " +c3);

        System.out.println("Numbers that are in the first and second collections");
        c3.clear(); c3.addAll(c1); c3.retainAll(c2);
        System.out.println(c2+"retainAll"+c2+" = " +c3);

        System.out.println("Numbers that are in the first and second collections");
        c3.clear(); c3.addAll(c2); c3.retainAll(c1);
        System.out.println(c2+"retainAll"+c1+ " = "+ c3);
        System.out.println();
    }

    public void three(){
        Collection<Integer> c1 = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            c1.add(rnd.nextInt(10));
        }

        Collection<Integer> c2 = new LinkedHashSet<>();
        c2.addAll(c1);
        boolean b1 = c1.containsAll(c1);
        System.out.println(c1 + "containAll" + c2 + "=" + b1);

        Collection<Integer> c3 = new TreeSet<>();
        c3.addAll(c1);
        boolean b2 = c1.containsAll(c3);
        System.out.println(c1 + "containsAll" + c3 + "=" + b2);
    }

    public void four(){
        ArrayList<Integer> c1 = new ArrayList<>();
        for(int i = 0; i <10; i++)
        {
            c1.add(rnd.nextInt(10));
        }
        System.out.println("Before sorting");
        System.out.println(c1);
        c1.sort(new Comparator<Integer>()
        {
            @Override
            public int compare(Integer a, Integer b)
            {
                return a-b;
            }
        });
        System.out.println("After sorting");
        System.out.println(c1);
    }

    public void five(){
        Collection<Integer> coll = new ArrayDeque<>();

        Collections.addAll(coll, 1, 3, 5, 3, 4, 2, 14);
        Collections.addAll(coll, new Integer[]{3,7,12});
        System.out.println("coll = " + coll);
        System.out.println("Collections.frequency = " + Collections.frequency(coll, 3));
        System.out.println("Collections.max = " + Collections.max(coll));
        System.out.println("Collections.min = " + Collections.min(coll));


        List<Integer> list = new ArrayList<>(coll);
        System.out.println("list = " + list);
        Collections.swap(list, 2, 6);
        System.out.println("Swap = " + list);

        Collections.sort(list);
        System.out.println("Sort = " + list);

        System.out.println("Binary search = " + Collections.binarySearch(list, 3, (a,b)-> b - a));

        Collections.reverse(list);
        System.out.println("Reverse = " + list);

        Collections.shuffle(list);
        System.out.println("Shuffle = " + list);

        Collections.replaceAll(list, 3, 8);
        System.out.println("Replace All = " + list);

        Collections.fill(list, 0);
        System.out.println("Fill = " + list);
    }

    public void six(){
        System.out.print("\n\n");
        Set<Wood> set = new HashSet<>();
        set.add(new Wood(0, "Some tree", 2f));
        set.add(new Wood(4, "Some tree", 5f));
        set.add(new Wood(2, "Some tree", 3f));

        Wood a = new Wood(6, "Some tree", 5f);
        Wood b = new Wood(4, "Some tree", 2f);
        System.out.println(b.equals(a));
        System.out.println(a.hashCode() + " " + b.hashCode());
        set.forEach(System.out::println);
    }
}
