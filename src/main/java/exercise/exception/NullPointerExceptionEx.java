package exercise.exception;

public class NullPointerExceptionEx {
    public static void main(String[] args) {
        String str = null;
        String[] strings = null;

        try{
            System.out.println("qq");
            System.out.println(str.charAt(0));
            System.out.println("zz");
        } catch (NullPointerException e){
            System.out.println(e.toString());
            System.out.println("tt");
        }
    }
}
