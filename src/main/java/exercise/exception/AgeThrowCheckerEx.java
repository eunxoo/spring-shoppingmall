package exercise.exception;

import java.util.Scanner;

public class AgeThrowCheckerEx {
    public static void main(String[] args) {
        /**
         * 숫자 입력
         * 당신의 나이는 00살이시네요. 반갑습니다.
         */
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("나이를 입력하세요. 범위는 0~100살입니다.");
                int age = scanner.nextInt();
                if (age == -1) {
                    break;
                }

                if (age < 0 || age > 100) {
                    throw new InputBoundErrorException("범위 밖입니다.");
                }
                System.out.println("당신의 나이는 " + age + "살이시네요. 반갑습니다.");
            } catch (InputBoundErrorException e){
                System.out.println(e.getMessage());
            } finally {
                scanner.close();
            }
        }
    }
}
