package exercise.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiCatchEx {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cards = {7, 9, 3, 5, 4, 1};
        System.out.println("몇 번째 카드를 뽑으실래요?");
        try {
            int cardIdx = scanner.nextInt();
            System.out.println("뽑은 카드 번호는 : " + cardIdx);
            System.out.println("뽑은 카드 숫자는 : " + cards[cardIdx - 1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        } catch (InputMismatchException e){
            System.out.println(e);
        }


    }
}
