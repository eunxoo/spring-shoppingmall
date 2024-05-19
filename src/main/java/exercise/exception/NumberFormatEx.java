package exercise.exception;

import java.util.Scanner;

public class NumberFormatEx {
    public static void main(String[] args) {
        System.out.println("점수를 입력하세요. ");
        Scanner scanner = new Scanner(System.in);

        while (true) {
                String input = scanner.nextLine();
                if (input.equals("q"))
                    break;
            try {
                int score = Integer.parseInt(input);

                if (score >= 60) {
                    System.out.println("합격입니다.");
                } else {
                    System.out.println("다음에 다시 봐요.");
                }

            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력값입니다.");
            }
        }

        System.out.println("프로그램 종료");
        scanner.close();
    }
}
