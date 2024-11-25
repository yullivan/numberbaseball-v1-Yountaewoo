package numberbaseball;

import java.util.Random;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("숫자 야구 게임을 시작합니다!");
            System.out.println("1부터 9까지의 서로 다른 숫자 3개를 맞춰보세요.");

            Random random = new Random();

            //첫번째 숫자 뽑기
            int firstRandomint = random.nextInt(8) + 1;

            System.out.println("firstRandomint = " + firstRandomint);

            //두번째 숫자 뽑기
            int secondRandomint = random.nextInt(8) + 1;

            // 첫번째 숫자와 두번째 숫자가 같지 않게 하는 방법
            while (secondRandomint == firstRandomint) {
                secondRandomint = random.nextInt(8) + 1;
                if (secondRandomint != firstRandomint) {
                    break;
                }
            }
            System.out.println("secondRandomint = " + secondRandomint);

            //세번째 숫자 뽑기
            int thirdRandomint = random.nextInt(8) + 1;

            //세번째 숫자가 첫번째와 두번째와 같지 않게 하는 방법
            while (thirdRandomint == secondRandomint || thirdRandomint == firstRandomint) {
                thirdRandomint = random.nextInt(8) + 1;
                if (firstRandomint != thirdRandomint && secondRandomint != thirdRandomint) {
                    break;
                }
            }
            System.out.println("thirdRandomint = " + thirdRandomint);


            while (true) {
                // 사용자 입력 받기 (이 부분은 완성되어 있음)
                System.out.print("\n첫 번째 숫자를 입력하세요: ");
                int user1 = scanner.nextInt();
                System.out.print("두 번째 숫자를 입력하세요: ");
                int user2 = scanner.nextInt();
                System.out.print("세 번째 숫자를 입력하세요: ");
                int user3 = scanner.nextInt();


                // 3스트라이크인 경우 + 게임 종료
                if (user1 == firstRandomint && user2 == secondRandomint && user3 == thirdRandomint) {
                    System.out.println("3 스트라이크");
                    break;
                }
                // 2스트라이크인 경우
                if ((user1 == firstRandomint && user2 == secondRandomint && user3 != thirdRandomint) ||
                        (user1 == firstRandomint && user2 != secondRandomint && user3 == thirdRandomint) ||
                        (user1 != firstRandomint && user2 == secondRandomint && user3 == thirdRandomint)) {
                    System.out.println("2 스트라이크");
                }
                //1스트라이크인 경우
                if ((user1 == firstRandomint && user2 != secondRandomint && user3 != thirdRandomint) ||
                        (user1 != firstRandomint && user2 == secondRandomint && user3 != thirdRandomint) ||
                        (user1 != firstRandomint && user2 != secondRandomint && user3 == thirdRandomint)) {
                    System.out.println("1 스트라이크");
                }
            }

            System.out.println("축하합니다! 정답을 맞추셨습니다.");

            //다음 게임의 여부 물어보기
            System.out.println("다음 게임을 하시겠습니까? : (yes/no)");
            String answer = scanner.nextLine();
            answer = scanner.nextLine();

            //yes/no 가 아닌 다른 답이 왔을때
            while (!answer.equals("yes") && !answer.equals("no")) {
                System.out.println("다시 입력하십시오 : (yes/no)");
                answer = scanner.nextLine();

                if (answer.equals("yes") || answer.equals("no")) {
                    break;
                }
            }

            if (answer.equals("no")) {
                System.out.println("게임종료");
                break;
            }

        }

    }
}