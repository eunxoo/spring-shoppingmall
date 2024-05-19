package exercise.generics;

import java.util.ArrayList;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<String> stackStr = new MyStack();
        System.out.println(stackStr.isEmpty());
        stackStr.push("a");
        stackStr.push("b");
        stackStr.push("c");

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek());
        System.out.println(stackStr.isEmpty());

        stackStr.printElements();


        MyStack<Integer> stackInt = new MyStack();
        stackInt.push(1);
        stackInt.push(2);
        stackInt.push(3);

        System.out.println(stackInt.pop());

        stackInt.printElements();
    }
}

class MyStack<T>{
    ArrayList<T> arrayList = new ArrayList<T>();

    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    public void push(T a) {
        arrayList.add(a);
    }

    public T pop() {
        return arrayList.remove(arrayList.size() - 1);
    }

    public T peek() {
        return arrayList.get(arrayList.size() - 1);
    }

    public void printElements() {
        for (T t : arrayList){
            System.out.print(t + " ");
        }
        System.out.println();
    }
}