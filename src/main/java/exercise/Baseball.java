package exercise;

import java.util.*;

public class Baseball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(3);
        answer.add(2);
        answer.add(6);
        int chance = 10;

        System.out.println("================== 숫자야구 게임 시작 ==================");
        System.out.println();

        while (chance > 0) {
            try {
                System.out.print("중복 없이 숫자 3개를 입력하세요. (공백으로 구분하기): ");
                String playerInput = scanner.nextLine();
                String[] playerInputs = playerInput.split(" ");

                if (playerInputs.length != 3) {
                    System.out.println("숫자 3개를 입력해야합니다. 다시 입력하세요.");
                    continue;
                }

                boolean isValid = true;
                for (String numStr : playerInputs) {
                    int num = Integer.parseInt(numStr);
                    if (num < 0 || num > 9) {
                        isValid = false;
                        break;
                    }
                }

                if (!isValid) {
                    System.out.println("0-9까지 숫자를 입력해야합니다. 다시 입력하세요.");
                    continue;
                }

                int strike = 0;
                int ball = 0;
                int out = 0;

                for (int i = 0; i < answer.size(); i++) {
                    int playerNum = Integer.parseInt(playerInputs[i]);
                    if (playerNum == answer.get(i)) {
                        strike++;
                    } else if (answer.contains(playerNum)) {
                        ball++;
                    } else {
                        out++;
                    }
                }

                if (strike == 3) {
                    System.out.println("3S 정답입니다!");
                    break;
                } else {
                    System.out.println(strike + "S " + ball + "B " + out + "O");
                }

                chance--;
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e){
                System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }

        if (chance == 0) {
            System.out.println("기회가 소진되었습니다. 다시 도전하세요 ㅜ.ㅜ");
        }
    }
}
