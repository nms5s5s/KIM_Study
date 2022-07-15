package ISSUE_1_3;

public class Human {
    public Human() {
    }

    public void Kim() {
        while(true) {
            int kim_num = (int)(Math.random() * 5.0) + 5;
            System.out.println(kim_num);
            if (kim_num == 5) {
                System.out.println("" + kim_num + "번 kim님이 선호하는 채널로 켭니다");
                return;
            }

            System.out.println("로딩중...");
        }
    }
}
