package OOPS;


import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

class Arraylist{
    int[]arr;
    private static int idx = 0;
    Arraylist(){
        this.arr = new int[5];
    }

    // to add a new element
    void add(int x){
        if (idx >= this.arr.length)
            arr = Arrays.copyOf(arr, 2*arr.length);
        this.arr[idx++] = x;
    }

    // to find the size of Arraylist
    int size(){
        return idx;
    }

    // tto find the element present at index
    int get(int i){
        if (i < idx)
            return this.arr[i];
        throw new RuntimeException();
    }

    // to find the index of particular element
    int indexOf(int i){
        for (int j = 0;j < arr.length;j++)
            if (this.arr[j] == i)
                return j;
        return -1;
    }

    // to print the ArrayList
    void print(){
        System.out.print('[');
        for (int i = 0;i < idx;i++)
            System.out.print(arr[i] + ",");
        System.out.println(']');
    }
}
public class O5_Own_ArrayList {
    public static void main(String[] args) {
        Arraylist a = new Arraylist();
        for (int i = 0;i < 15;i++) {
            int num = ThreadLocalRandom.current().nextInt(1,50);
            a.add(num);
        }
        System.out.println(a.size());
        a.print();
        a.add(69);
        System.out.println(a.indexOf(69));
        System.out.println(a.get(14));
        a.print();
    }
}