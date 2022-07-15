package ISSUE_2;

public class middle extends bigblock implements Human{
    String name = "숙련자";
    int speed = 60;
    @Override
    public void speed() {
        System.out.println(name+"는 " + speed + " km로 달립니다");
    }
}
