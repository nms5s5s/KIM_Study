package ISSUE_2;

public class master extends bigblock implements Human{
    String name = "전문가";
    int speed = 100;

    @Override
    public void speed() {
        System.out.println(name+"는 "+speed+" km로 달립니다");
    }
}
