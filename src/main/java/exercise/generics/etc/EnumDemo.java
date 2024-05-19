package exercise.generics.etc;

public enum EnumDemo {
//    int menu = 0;
//    public static final int americano = 0;
//    public static final int latte = 1;
//    public static final int strawberryAde = 2;
//    public static final int espresso = 3;

    AMERICANO(0, "아메리카노"),
    LATTE(1,"라떼"),
    STRAWBERRY_ADE(2,"딸기 에이드"),
    ESPRESSO(3,"에스프레소");

    private final int menuNum;
    private final String menuName;

    EnumDemo(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public void selectMenu(){
        System.out.println(menuName);

    }
}


//public class EnumDemo {
//    enum Menu {
//        AMERICANO, LATTE, STRAWBERRY_ADE, ESPRESSO
//    }
//
//    Menu menu;
//
//    public void selectMenu(){
//        switch (menu){
//            case AMERICANO:
//                System.out.println("아메리카노");
//                break;
//            case LATTE:
//                System.out.println("라떼");
//                break;
//            case STRAWBERRY_ADE:
//                System.out.println("딸기 에이드");
//                break;
//            case ESPRESSO:
//                System.out.println("에스프레소");
//                break;
//        }
//    }
//}

