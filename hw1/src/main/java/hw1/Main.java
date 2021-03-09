package hw1;

import hw1.fruits.Apple;
import hw1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = {"apple", "cat", "box", "dog"};
        System.out.println(Arrays.toString(array));
        reverseArrayElements(array, 1,3);
        System.out.println(Arrays.toString(array));

        ArrayList<String> arrList = arrayToList(array);
        System.out.println(arrList);

        Box<Apple> box1 = new Box<>();
        box1.add(new Apple());
        box1.add(new Apple());
        System.out.println(box1.getWeight());

        Box<Apple> box2 = new Box<>();
        box2.add(new Apple());
        box2.add(new Apple());
        System.out.println(box2.compare(box1));
        box2.transfer(box1);
        System.out.println("box1 = " + box1.getWeight() + " box2 = " + box2.getWeight());

        Box<Orange> box3 = new Box<>();
        box3.add(new Orange());
        box3.add(new Orange());
        System.out.println(box3.compare(box1));
        System.out.println("box1 = " + box1.getWeight() + " box3 = " + box3.getWeight());

    }
    public static <T>ArrayList<T> arrayToList (T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }


    public static void  reverseArrayElements (Object[] arr, int index1, int index2){
        Object bufferObj = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = bufferObj;
           }
}
