import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayList<T> {
    private int sizeArrayList;
    private  final int CAPACITY = 5;
    private Object[] basicArray;

    public MyArrayList() {
        basicArray = new Object[CAPACITY];
        this.sizeArrayList = 0;
    }

    public MyArrayList(int capacity) {
        basicArray = new Object[capacity];
        this.sizeArrayList = 0;

    }

    public int size() {
        return sizeArrayList;
    }

    public void add(T value) {
        if (sizeArrayList < basicArray.length) {
            basicArray[sizeArrayList] = value;
            sizeArrayList++;
        } else{
           Object[] temp  = new Object[basicArray.length + (basicArray.length / 2)];
           int i=0;
           for (Object item:basicArray) {
               temp[i] = item;
               i++;
           }
            sizeArrayList = i;
            basicArray = temp;
            basicArray[sizeArrayList] = value;
            sizeArrayList++;
        }

    }
    public Object get (int index){
        return basicArray[index];
    }
    public void clear(){
        for (int i =0; i<basicArray.length;i++) {
            basicArray[i] = null;
            sizeArrayList=0;

        }
    }
    public void remove(int index){
        for (int i = index; i < basicArray.length-1; i++) {
            basicArray[i]=basicArray[i+1];

        }
        sizeArrayList--;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object item: basicArray) {
            if(item !=null){
                sb.append(item);
            }

        }
        return sb.toString();
    }
    public static void main(String[] args) {

        MyArrayList <String> ml = new MyArrayList<>();
        ml.add("1");
        ml.add("2");
        ml.add("3");
        ml.add("4");
        ml.add("5");
        ml.add("6");
        ml.add("7");
        ml.add("8");
        MyArrayList<Integer> malInt = new MyArrayList<>();
        malInt.add(5);
        malInt.add(4);

        System.out.println(ml);
        System.out.println(ml.size());
        System.out.println(ml.get(5));
        System.out.println((Integer)malInt.get(0)+(Integer)malInt.get(1));
        malInt.clear();
        System.out.println(malInt);
        System.out.println(malInt.size());
        ml.remove(2);
        System.out.println(ml);
        System.out.println(ml.size());

    }
}

