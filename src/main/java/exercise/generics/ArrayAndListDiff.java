package exercise.generics;

import java.util.ArrayList;
import java.util.List;

public class ArrayAndListDiff {
    public static void main(String[] args) {
        Object[] arr = new Object[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = "string";

        for(Object i : arr){
            System.out.println(i);
        }

        List<Object> list = new ArrayList<>();

        list.add(100);
        list.add(6.22);
        list.add("Spring");
        list.add(true);

        // List 순회하며 출력
        for (Object item : list) {
            System.out.println(item);
        }

    }
}
