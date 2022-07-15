package ISSUE_1_3;

public class LoveChannel {
    public LoveChannel() {
    }

    public static void main(String[] args) {
        AUTO();
    }

    public static void LOGIN() {
        Login log = new Login();
        log.login();
    }

    public static void AUTO() {
        Human human = new Human();
        human.Kim();
    }
}
