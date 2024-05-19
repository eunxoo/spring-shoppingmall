package exercise.exception;

public class ArrayIndexOutOfBoundsEx {
    // 예외 발생 상황
    // try catch
    // 어떤 예외 클래스로 예외 받아줄 건지
    public static void main(String[] args) {
        int arr[] = {1, 2, 3};
        try{
            System.out.println(arr[4]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.toString());
            System.out.println("배열 인덱스 모자라");
        }

    }
}
