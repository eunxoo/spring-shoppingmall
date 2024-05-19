package exercise.generics;

public class AutoUnboxing {
    public static void main(String[] args) {
        Int num1 = new Int(7);
        System.out.println(num1.i);

        int num2 = 8;
        System.out.println(num2);

        // Deprecated 되어서 이건 쓰지 말자!
//        Integer num3 = new Integer(2);
        // 대안
        Integer num4 = Integer.valueOf(44);
        System.out.println(num4);
    }
}

class Int {
    int i;
    Int(int i){
        this.i = i;
    }
}
