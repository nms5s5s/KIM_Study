package ISSUE_2;

public class basic extends bigblock implements Human{
    String name = "초보자";
    int speed = 30;


    @Override
    public void speed() {
        System.out.println(name + "는 " + speed +" km로 달립니다");
    }
}
